package kr.or.phonejob.smart.s_Dao;

import kr.or.phonejob.smart.s_Dto.s_ShopDto;

import java.util.List;

public interface s_ShopDao {

    List<s_ShopDto> s_selectPhoneList();    //폰 리스트 조회
    s_ShopDto s_selectPhoneDetail(String phone_seq);    //폰 세부정보 조회(param phone_seq)

}
