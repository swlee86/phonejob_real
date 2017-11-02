package kr.or.phonejob.ShopController;

import kr.or.phonejob.Dto.ShopDto;
import kr.or.phonejob.Service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value="/shop/shopMain.do", method=RequestMethod.GET)
	public String goShop(Model mv){
		String url ="shop.shopMain";
        List<ShopDto> result = null;
        try{
            result = sservice.selectPhoneList();
        }catch(Exception e){
		    e.printStackTrace();
        }finally {
            mv.addAttribute("result",result);
        }

		return url;
	}

	//phone 상세 페이지 접근
    @RequestMapping(value="/shop/shopDetail.do", method=RequestMethod.GET)
	public String phoneDetail(String phone_seq, Model mv){
        String url="shop.phoneDetail";
        ShopDto result = null;

        try{
            result= sservice.selectPhoneDetail(phone_seq);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mv.addAttribute("result", result);
        }
        return url;
    }

}
