package kr.or.phonejob.BoardController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.phonejob.Dto.FreeBoardDto;
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
		String link = null;
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
			
		}finally{
			mv.addAttribute("list", freeboard);
			mv.addAttribute("re_list", re_list);
			mv.addAttribute("currentpage", currentpage);
			mv.addAttribute("pagesize", pagesize);
			mv.addAttribute("rec_emp_no",rec_emp_no);

			link = "free_board.free_board_view";
		}
		
		return link;
	}
}
