package kr.or.phonejob.ShopController;

import kr.or.phonejob.Service.ShopService;
import kr.or.phonejob.Dto.ShopDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
생성일자 : 2017-10-04
작성자 : 이상원
문서정보 : shop Controller

*/

@Controller
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Autowired
    private ShopService sservice;

	//shop 페이지 오픈
	@RequestMapping(value={"/shop/shopMain.do","/shop/s_shopMain.do"}, method=RequestMethod.GET)
	public String goShop(HttpServletRequest request, Model mv){
		String url;
        List<ShopDto> result = null;
        try{
            result = sservice.selectPhoneList();
        }catch(Exception e){
		    e.printStackTrace();
        }finally {
            if(request.getRequestURI().equals("/shop/s_shopMain.do")){
                url= "smart.s_shop.s_shopMain";
            }else{
                url= "shop.shopMain";
            }
            mv.addAttribute("result",result);
        }

		return url;
	}

	//phone 상세 페이지 접근
    @RequestMapping(value={"/shop/shopDetail.do","/shop/s_shopDetail.do"}, method=RequestMethod.GET)
	public String phoneDetail(HttpServletRequest request, String phone_seq, Model mv){
        String url;
        ShopDto result = null;

        try{
            result= sservice.selectPhoneDetail(phone_seq);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(request.getRequestURI().equals("/shop/s_shopDetail.do")){
                url= "smart.s_shop.s_phoneDetail";
            }else{
                url= "shop.phoneDetail";
            }
            mv.addAttribute("result", result);
        }
        return url;
    }

}
