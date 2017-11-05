package kr.or.phonejob.BoardController;

import kr.or.phonejob.Dto.*;
import kr.or.phonejob.Service.NoticeBoardService;
import kr.or.phonejob.Util.MaskingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;


@Controller
public class NoticeBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	
	@Autowired
	private NoticeBoardService noticeservice;


	@RequestMapping(value="/notice/noticeBoardMain.do", method=RequestMethod.GET)
	public String goNoticeboard(Model mv, String pagesize, String currentpage, String f, String q){
		logger.info("공지사항으로 이동!");
		String url="notice_board.notice_board_list";

		
		int totalcount = 0;
		int pagecount = 0;
		
		String field = "title";
		String query ="%%";
		
        if(pagesize == null || pagesize.trim().equals("")){
            pagesize = "10"; 			// default 10건씩 
        }
        
        if(currentpage == null || currentpage.trim().equals("")){
            currentpage = "1";        //default 1 page
        }
        if(f != null && !f.equals("")){
			field = f;
		}
		if(q != null && !q.equals("")){
			query = q;
		}
        
		totalcount = noticeservice.selectNoticeCount(field, query);

        int pgsize = Integer.parseInt(pagesize);  		// 10
        int cpage = Integer.parseInt(currentpage);     //1
                               
        
        if(totalcount % pgsize==0){        //전체 건수 , pagesize 
            pagecount = totalcount/pgsize;
        }else{
            pagecount = (totalcount/pgsize) + 1;
        }
		
		List<NoticeBoardDto> list = null;

		try{
			 list = noticeservice.selectNoticeBoard(cpage, pgsize, field, query);
			 
			 for(int i=0; i<list.size(); i++){
				 list.get(i).setRe_count(noticeservice.selectReCount(list.get(i).getFree_no()));
				 logger.info("마스킹 작업 전 데이터 : " + list.get(i).toString());
				 list.get(i).setUserid(MaskingUtil.getMaskingId(list.get(i).getUserid()));
				 logger.info("마스킹 작업 후 데이터 : " + list.get(i).toString());
			 }
			 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			mv.addAttribute("list", list);
			mv.addAttribute("cpage", cpage);
			mv.addAttribute("pgsize", pgsize);
			mv.addAttribute("pagecount", pagecount);
			mv.addAttribute("totalcount", totalcount);
		}
		return url;
		
	}
	

	//글쓰기 클릭 시 해당 페이지로 이등
	@RequestMapping(value="/notice/noticeWrite.do", method=RequestMethod.GET)
	public String writeNoticeboard(){
		String url="notice_board.notice_board_write";
		return url;
	}




	//글쓰기 누르면 인서트 시키는 서비스 함수 + 파일업로드
	@RequestMapping(value="/notice/noticeWrite.do", method=RequestMethod.POST)
	public String notice_board_write_ok(@RequestParam("uploadfile") MultipartFile file, NoticeBoardDto board, Model mv, HttpServletRequest request){


		//파일 업로드
		String path = request.getSession().getServletContext().getRealPath("../updata/notice_board/");

		try {
			File cFile = new File(path, file.getOriginalFilename());
			logger.info("cFile 내용 : " + cFile);
			file.transferTo(cFile);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {

		}


		//로그인시 만들어진 세션 정보를 불러옴!!
		HttpSession session = request.getSession();
		LoginDto ldto= (LoginDto)session.getAttribute("loginData");
		logger.info("세션에서 불러온 값 : " + ldto.toString());

		String id= ldto.getUserid();
		int maxrefer = noticeservice.selectRefer();

		//게시판에 넣을 데이터 작업 시작
		board.setCredential_id(ldto.getCredential_id());
		board.setUserid(ldto.getUserid());
		board.setRefer(maxrefer+1);
		board.setDepth(0);
		board.setStep(0);
		board.setHit(0);
		board.setFilename(file.getOriginalFilename());

		logger.info("데이터 입력처리 될 boardDto : " + board.toString());


		int result = 0;
		String link = "../notice/noticeBoardMain.do";
		String msg = null;
		try{
			result = noticeservice.insertArticle(board);
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			if(result>0){
				msg = "글 입력에 성공하였습니다.";
				session.setAttribute("change_value", "공지사항 글 입력 성공");
				session.setAttribute("error_cd", "0000000");
			}else{
				msg = "글 입력에 실패하였습니다.";
				session.setAttribute("change_value", "공지사항 글 입력 실패");
				session.setAttribute("error_cd", "0000000");
			}
			mv.addAttribute("link", link);
			mv.addAttribute("msg", msg);
		}
		return "notice_board.notice_redirect";
	}


	//글 선택하여 내용 보기 함수
	@RequestMapping(value="/notice/noticeDetail.do", method=RequestMethod.GET)
	public String notice_board_view(Model mv, int free_no, String currentpage, String pagesize,HttpSession session){
		String url = null;
		NoticeBoardDto noticeboard = null;
		List<Re_NoticeBoardDto> re_list = null;

		try{
			noticeboard = noticeservice.selectDetail(free_no);
			re_list = noticeservice.selectReList(free_no);
			noticeservice.updateHit(free_no);
			logger.info(noticeservice.toString());
			logger.info(re_list.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			mv.addAttribute("list", noticeboard);
			mv.addAttribute("re_list", re_list);
			mv.addAttribute("currentpage", currentpage);
			mv.addAttribute("pagesize", pagesize);

			url = "notice_board.notice_board_view";
		}
		
		return url;
	}
	
	
		//답변하기 누르면 기존 글의 데이터를 가지고 가서 write 화면에 뿌려주는 함수
		@RequestMapping(value="/notice/noticeReplyComple.do", method=RequestMethod.GET)
		public String NoticeAnswer(Model mv, int free_no, int currentpage, int pagesize){
			String link = null;
			NoticeBoardDto noticeboard = null;
			try{
				noticeboard = noticeservice.selectDetail(free_no);
				noticeboard.setContent("<p><br><br></p><p>====================================이전 글====================================<br></p>"+noticeboard.getContent());
			}catch(Exception e){

			}finally{
				mv.addAttribute("list", noticeboard);
				mv.addAttribute("currentpage", currentpage);
				mv.addAttribute("pagesize", pagesize);
				link = "notice_board.notice_board_answer";
			}
			return link;
		}
	
	
	
		//답변 인서트 컨트롤러
		@RequestMapping(value="/notice/noticeReplyComple.do", method=RequestMethod.POST)
		public String NoticeAnswerOk(@RequestParam("uploadfile") MultipartFile file, Model mv, String title, String content, String free_no, Principal principal, int refer, int step, int depth, HttpServletRequest request){
			//파일 업로드
			String path = request.getSession().getServletContext().getRealPath("../notice/notice_upload/");

			File cFile = new File(path, file.getOriginalFilename());
			try {
				file.transferTo(cFile);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			//로그인시 만들어진 세션 정보를 불러옴!!
			HttpSession session = request.getSession();
			LoginDto ldto= (LoginDto)session.getAttribute("loginData");
			logger.info("세션에서 불러온 값 : " + ldto.toString());

			NoticeBoardDto noti = new NoticeBoardDto();
			String link = null;
			String msg = null;
			int result = 0;

			noticeservice.updateStep(refer, step);

		if(noti.getFilename()==null){
			noti.setFilename("0");
		}

			noti.setCredential_id(ldto.getCredential_id());
			noti.setUserid(ldto.getUserid());
			noti.setRefer(refer);
			noti.setDepth(depth+1);//부모글의 depth +1
			noti.setStep(step+1);	//부모글의 스텝번호+1
			noti.setHit(0);
			noti.setTitle(title);
			noti.setFilename(file.getOriginalFilename());
			noti.setContent(content);
				
		try{
			result = noticeservice.insertArticle(noti);
		}catch(Exception e){
			e.getMessage();
		}finally{
			if(result > 0){
				link = "../notice/noticeBoardMain.do";
				msg = "답글 입력에 성공하였습니다.";
				session.setAttribute("change_value", free_no+" 에 대한 답글 성공");
				session.setAttribute("error_cd", "0000000");
		}else{
				link = "../notice/noticeBoardMain.do";
				msg = "답글 입력에 실패하였습니다.";
				session.setAttribute("change_value", free_no+" 에 대한 답글 실패");
				session.setAttribute("error_cd", "9999999");
		}
		mv.addAttribute("link", link);
		mv.addAttribute("msg", msg);
		}
			
		return "free_board.free_redirect";
	};
	
	
	//삭제 처리
	@RequestMapping(value="/notice/noticeDelete.do", method=RequestMethod.POST)
	public void deleteNotice(HttpServletRequest request, HttpServletResponse response){
		int list_no = Integer.parseInt(request.getParameter("list_no")); 
		int replyCount=0;
		int replyresult=0;
		int rowresult=0;
		logger.info("Ajax로 삭제하러 넘어왔어요! 넘어온 글 번호는 !" + list_no);

		HttpSession session = request.getSession();
	
        		
		try{
			response.setContentType("text/html;charset=euc-kr");
	        PrintWriter out = response.getWriter();
	        
			replyCount=noticeservice.selectReCount(list_no);
			logger.info("해당 글에는 댓글이 " + replyCount + "만큼 있네요");
			
			if(replyCount!=0){
				logger.info("댓긇 삭제를 시작합시다.");
				replyresult=noticeservice.deleteReply(list_no);
				
				if(replyresult==1){
					logger.info("댓글 삭제 했으니 본문도 삭제합시다.");
					rowresult=noticeservice.deleteRow(list_no);
					if(rowresult==1){
						logger.info("모두 성공!!");
						out.println("1");
						session.setAttribute("change_value", list_no+" 삭제 성공");
						session.setAttribute("error_cd", "0000000");
					}else{
						logger.info("본문 삭제 실패 ㅠㅠ");
						out.println("0");
						session.setAttribute("change_value", list_no+" 삭제 실패");
						session.setAttribute("error_cd", "9999999");
					}
				}

			}else{
				logger.info("댓긇이 없으니까 바로 삭제합시다.");
				rowresult=noticeservice.deleteRow(list_no);
				if(rowresult==1){
					logger.info("모두 성공!!");
					out.println("1");
					session.setAttribute("change_value", list_no+" 삭제 성공");
					session.setAttribute("error_cd", "0000000");
				}else{
					logger.info("본문 삭제 실패 ㅠㅠ");
					out.println("0");
					session.setAttribute("change_value", list_no+" 삭제 실패");
					session.setAttribute("error_cd", "9999999");
				}
			}
;



		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		

	}
	
	//글 수정으로 이동 하는 함수(글번호를 통해 데이터를 가지고 이동)
	@RequestMapping(value="/notice/noticeModify.do", method=RequestMethod.GET)
	public String notice_board_update(int free_no, String currentpage, String pagesize, Model mv){
		String url="";
		
		NoticeBoardDto noticeboard = null;
		try{
			url="notice_board.notice_board_rewrite";
			noticeboard = noticeservice.selectDetail(free_no);
			logger.info("수정할 데이터 : " + noticeboard.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			mv.addAttribute("freeboard", noticeboard);
			mv.addAttribute("currentpage", currentpage);
			mv.addAttribute("pagesize", pagesize);
		}
		
		return url;
	}
			
	

		//글수정 누르면 업데이트 시키는 서비스 함수 + 파일업로드
		@RequestMapping(value="/notice/noticeModifyComple.do", method=RequestMethod.POST)
		public String notice_board_update_ok(@RequestParam("uploadfile") MultipartFile file, NoticeBoardDto board, Model mv,HttpServletRequest request, int currentpage, int pagesize){
			HttpSession session = request.getSession();

			//파일 업로드
			String path = request.getRealPath("../notice/notice_board/");
			try {
				File cFile = new File(path, file.getOriginalFilename());
				logger.info("cFile 내용 : " + cFile);
				file.transferTo(cFile);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		//게시판에 넣을 데이터 작업 시작
		if(null!=file.getOriginalFilename()){
			board.setFilename(file.getOriginalFilename());			
		}else if(board.getFilename()==null){
			board.setFilename("");
		}
			
		
		logger.info("데이터 업데이트 될 boardDto : " + board.toString());
		
		int result = 0;
		String link = null;
		String msg = null;
		try{
			result = noticeservice.updateArticle(board);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(result>0){
				link = "/notice/noticeDetail.do?free_no="+board.getFree_no()+"&currentpage="+currentpage+"&pagesize="+pagesize;
				msg = "글 수정에 성공하였습니다.";
				session.setAttribute("change_value", board.getFree_no()+" 수정 성공");
				session.setAttribute("error_cd", "0000000");
			}else{
				link = "/notice/noticeBoardMain.do";
				msg = "글 수정에 실패하였습니다.";
				session.setAttribute("change_value", board.getFree_no()+" 수정 실패");
				session.setAttribute("error_cd", "0000000");
			}
			mv.addAttribute("link", link);
			mv.addAttribute("msg", msg);
		}
		return "notice_board.notice_redirect";
	}
	
	
	//댓글 달기 method
	@RequestMapping(value="/notice/noticeCommentComple.do", method=RequestMethod.POST)
	public String insertNoticeReply(HttpServletRequest request, Re_NoticeBoardDto rdto, Model mv){
		HttpSession session = request.getSession();

		logger.info("댓글 입력 시작합니다");
		logger.info("Re_NoticeDtoData : " + rdto.toString());
		int result;
		String url="notice_board.notice_redirect";
		String link=null;
		String msg=null;
		
		try{
			result=noticeservice.insertReply(rdto);

			if(result>0){
				link="/notice/noticeDetail.do?free_no="+rdto.getFree_no()+"&currentpage="+rdto.getCurrentpage()+"&pagesize="+rdto.getPagesize();
				msg="등록에 성공하였습니다";
				session.setAttribute("change_value", rdto.getFree_no()+" 댓글 작성 성공");
				session.setAttribute("error_cd", "0000000");
			}else{
				link="../notice/noticeDetail.do?free_no="+rdto.getFree_no()+"&currentpage="+rdto.getCurrentpage()+"&pagesize="+rdto.getPagesize();
				msg="등록에 실패하였습니다. 동일 현상이 지속될 경우 관리자에게 문의하세요";

			}
		}catch(Exception e){
			e.printStackTrace();
				}finally{
				mv.addAttribute("link", link);
				mv.addAttribute("msg", msg);
				session.setAttribute("change_value", rdto.getFree_no()+" 댓글 작성 실패");
				session.setAttribute("error_cd", "9999999");
				}

				return url;
		}




}
