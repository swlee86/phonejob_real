package kr.or.phonejob.smart.s_CommuController;

import kr.or.phonejob.pc.Dto.FreeBoardDto;
import kr.or.phonejob.smart.s_Dto.s_NoticeBoardDto;
import kr.or.phonejob.pc.Service.FreeBoardService;
import kr.or.phonejob.smart.s_Service.s_NoticeBoardService;
import kr.or.phonejob.pc.Util.MaskingUtil;
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
public class s_CommuController {

    private static final Logger logger = LoggerFactory.getLogger(s_CommuController.class);

    @Autowired
    private FreeBoardService fservice;

    @Autowired
    private s_NoticeBoardService nservice;

    @RequestMapping(value = "/commu/s_commuMain.do", method = RequestMethod.GET)
    public String s_commuMain(HttpServletRequest request, Model mv, String pagesize, String currentpage, String f, String q){
        String url = "smart.s_community.s_commuMain";

        //세션 설정
        HttpSession session = request.getSession();

        List<FreeBoardDto> list = null;
        List<s_NoticeBoardDto> noticelist = null;


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
            noticelist = nservice.selectNoticeBoard(cpage, pgsize, field, query);

            for(int i=0; i<list.size(); i++){
                list.get(i).setRe_count(fservice.selectReCount(list.get(i).getFree_no()));
                list.get(i).setUserid(MaskingUtil.getMaskingId(list.get(i).getUserid()));
                logger.info("마스킹 작업 후 데이터 : " + list.get(i).toString());
            }

            for(int j=0; j<noticelist.size(); j++){
                noticelist.get(j).setRe_count(nservice.selectReCount(noticelist.get(j).getNotice_no()));
                noticelist.get(j).setUserid(MaskingUtil.getMaskingId(noticelist.get(j).getUserid()));
                logger.info("마스킹 작업 후 데이터 : " + noticelist.get(j).toString());
            }



        }catch(Exception e){
            e.printStackTrace();
        }finally{
            mv.addAttribute("list", list);
            mv.addAttribute("noticelist", noticelist);
        }


        return url;
    }
}
