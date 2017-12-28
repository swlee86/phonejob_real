package kr.or.phonejob.smart.s_ShopController;

import kr.or.phonejob.smart.s_Dto.s_ShopDto;
import kr.or.phonejob.smart.s_Service.s_ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
생성일자 : 2017-12-28
작성자 : 이상원
문서정보 : 모바일 shop Controller

*/

@Controller
public class s_ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(s_ShopController.class);

	@Autowired
    private s_ShopService sservice;

	//shop 페이지 오픈
	@RequestMapping(value="/shop/s_shopMain.do", method=RequestMethod.GET)
	public String goShop(Model mv){
		String url ="smart.s_shop.s_shopMain";
        List<s_ShopDto> result = null;
        try{
            result = sservice.s_selectPhoneList();
        }catch(Exception e){
		    e.printStackTrace();
        }finally {
            mv.addAttribute("result",result);
        }

		return url;
	}

	//phone 상세 페이지 접근
    @RequestMapping(value="/shop/s_shopDetail.do", method=RequestMethod.GET)
	public String phoneDetail(String phone_seq, Model mv){
        String url="smart.s_shop.s_phoneDetail";
        s_ShopDto result = null;

        try{
            result= sservice.s_selectPhoneDetail(phone_seq);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mv.addAttribute("result", result);
        }
        return url;
    }

}
