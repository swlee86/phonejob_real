package kr.or.phonejob.CommuController;

import kr.or.phonejob.Dto.FreeBoardDto;
import kr.or.phonejob.Service.FreeBoardService;
import kr.or.phonejob.Util.MaskingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommuController {

    private static final Logger logger = LoggerFactory.getLogger(CommuController.class);

    @Autowired
    private FreeBoardService fservice;

    @RequestMapping(value = "/commu/commuMain.do", method = RequestMethod.GET)
    public String commuMain(HttpServletRequest request, Model mv, String pagesize, String currentpage, String f, String q){
        String url = "community.commuMain";

        //세션 설정
        HttpSession session = request.getSession();

        List<FreeBoardDto> list = null;


        try{
            int totalcount = 0;
            int pagecount = 0;

            String field = "title";
            String query ="%%";

            if(pagesize == null || pagesize.trim().equals("")){
                pagesize = "5"; 			// default 10건씩
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

            totalcount = fservice.selectBoardCount(field, query);

            int pgsize = Integer.parseInt(pagesize);  		// 10
            int cpage = Integer.parseInt(currentpage);     //1


            if(totalcount % pgsize==0){        //전체 건수 , pagesize
                pagecount = totalcount/pgsize;
            }else{
                pagecount = (totalcount/pgsize) + 1;
            }

            list = fservice.selectBoard(cpage, pgsize, field, query);

            for(int i=0; i<list.size(); i++){
                list.get(i).setRe_count(fservice.selectReCount(list.get(i).getFree_no()));
                logger.info("마스킹 작업 전 데이터 : " + list.get(i).toString());
                list.get(i).setUserid(MaskingUtil.getMaskingId(list.get(i).getUserid()));
                logger.info("마스킹 작업 후 데이터 : " + list.get(i).toString());
            }



        }catch(Exception e){
            e.printStackTrace();
        }finally{
            mv.addAttribute("list", list);
        }


        return url;
    }
}
