package kr.or.phonejob.BoardController;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import kr.or.phonejob.Dto.FreeBoardDto;
import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Dto.Re_FreeBoard;
import kr.or.phonejob.Service.FreeBoardService;


@Controller
public class FreeBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	
	@Autowired
	private FreeBoardService freeboardservice;
	
	

	@RequestMapping(value="/freeboard.do", method=RequestMethod.GET)
	public String goFreeboard(Model mv, String pagesize, String currentpage, String f, String q){
		logger.info("게시판으로 이동!");
		String url="free_board.free_board_list";

		
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
        
		totalcount = freeboardservice.selectBoardCount(field, query);

        int pgsize = Integer.parseInt(pagesize);  		// 10
        int cpage = Integer.parseInt(currentpage);     //1
                               
        
        if(totalcount % pgsize==0){        //전체 건수 , pagesize 
            pagecount = totalcount/pgsize;
        }else{
            pagecount = (totalcount/pgsize) + 1;
        }
		
		List<FreeBoardDto> list = null;

		try{
			 list = freeboardservice.selectBoard(cpage, pgsize, field, query); 
			 logger.info(list.toString());
		}catch(Exception e){
			e.getMessage();
		}finally{
			mv.addAttribute("list", list);
			mv.addAttribute("cpage", cpage);
			mv.addAttribute("pgsize", pgsize);
			mv.addAttribute("pagecount", pagecount);
			mv.addAttribute("totalcount", totalcount);
		}
		return url;
		
	}
	
	
	@RequestMapping(value="/writefreeboard.do", method=RequestMethod.GET)
	public String writeFreeboard(){
		String url="free_board.free_board_write";
		
		return url;
	}
	
	
	@RequestMapping(value="/free_board_view.do", method=RequestMethod.GET)
	public String free_board_view(Model mv, int free_no, String currentpage, String pagesize,HttpSession session){
		String url = null;
		FreeBoardDto freeboard = null;
		List<Re_FreeBoard> re_list = null;
		String rec_emp_no = (String)session.getAttribute("emp_no");

		try{
			freeboard = freeboardservice.selectDetail(free_no);
			re_list = freeboardservice.selectReList(free_no);
			freeboardservice.updateHit(free_no);
			logger.info(freeboard.toString());
			logger.info(re_list.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			mv.addAttribute("list", freeboard);
			mv.addAttribute("re_list", re_list);
			mv.addAttribute("currentpage", currentpage);
			mv.addAttribute("pagesize", pagesize);
			mv.addAttribute("rec_emp_no",rec_emp_no);

			url = "free_board.free_board_view";
		}
		
		return url;
	}
	
	
	
	//글쓰기 누르면 인서트 시키는 서비스 함수 + 파일업로드
	@RequestMapping(value="/writefreeboard.do", method=RequestMethod.POST)
	public String free_board_write_ok(@RequestParam("uploadfile") MultipartFile file, FreeBoardDto board, Model mv,HttpServletRequest request){
	
		//파일 업로드 
		 String path = request.getRealPath("/board/free_upload/");

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
		
		String id= ldto.getUserid();
		int maxrefer = freeboardservice.selectRefer();
		
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
		String link = null;
		String msg = null;
		try{
			result = freeboardservice.insertArticle(board);
		}catch(Exception e){
			e.getMessage();
		}finally{
			if(result>0){
				link = "freeboard.do";
				msg = "글 입력에 성공하였습니다.";
			}else{
				link = "freeboard.do";
				msg = "글 입력에 실패하였습니다.";
			}
			mv.addAttribute("link", link);
			mv.addAttribute("msg", msg);
		}
		return "free_board.free_redirect";
	}
	
	
	
	
	
	
	//답변하기 누르면 기존 글의 데이터를 가지고 가서 write 화면에 뿌려주는 함수
	@RequestMapping(value="/answerfree.do", method=RequestMethod.GET)
	public String answer(Model mv, int free_no, int currentpage, int pagesize){
		String link = null;
		FreeBoardDto freeboard = null;
		try{
			freeboard = freeboardservice.selectDetail(free_no);
			freeboard.setContent("<p><br><br></p><p>====================================이전 글====================================<br></p>"+freeboard.getContent());
		}catch(Exception e){
			
		}finally{
			mv.addAttribute("list", freeboard);
			mv.addAttribute("currentpage", currentpage);
			mv.addAttribute("pagesize", pagesize);
			link = "free_board.free_board_answer";
		}
		return link;
	}
	
	
	
			//답변 인서트 컨트롤러 
			@RequestMapping(value="/answerfree.do", method=RequestMethod.POST)
			public String answerOk(@RequestParam("uploadfile") MultipartFile file, Model mv, String title, String content, String free_no, Principal principal, int refer, int step, int depth,HttpServletRequest request){
				//파일 업로드 
				String path = request.getRealPath("/board/free_upload/");
				
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
				
				FreeBoardDto free = new FreeBoardDto();
				String link = null;
				String msg = null;
				int result = 0;
				
				freeboardservice.updateStep(refer, step);

				if(free.getFilename()==null){
						free.setFilename("0");
				}
				
				free.setCredential_id(ldto.getCredential_id());
				free.setUserid(ldto.getUserid());
				free.setRefer(refer);
				free.setDepth(depth+1);//부모글의 depth +1
				free.setStep(step+1);	//부모글의 스텝번호+1
				free.setHit(0);
				free.setTitle(title);
				free.setFilename(file.getOriginalFilename());
				free.setContent(content);
				
				try{
					result = freeboardservice.insertArticle(free);
				}catch(Exception e){
					e.getMessage();
				}finally{
					if(result > 0){
					link = "freeboard.do";
					msg = "답글 입력에 성공하였습니다.";
				}else{
					link = "freeboard.do";
					msg = "답글 입력에 실패하였습니다.";
				}
				mv.addAttribute("link", link);
				mv.addAttribute("msg", msg);
				}
				
				return "free_board.free_redirect";
			}
	
	
	
	
	
}
