package kr.or.phonejob.CommuController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommuController {

    @RequestMapping(value = "/commu/commuMain.do", method = RequestMethod.GET)
    public String commuMain(){
        String url = "community.commuMain";
        return url;
    }
}
