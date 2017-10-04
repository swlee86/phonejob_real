package kr.or.phonejob.Dao;

import kr.or.phonejob.Dto.ShopDto;

import java.util.List;

public interface ShopDao {

    List<ShopDto> selectPhoneList();    //폰 리스트 조회
    ShopDto selectPhoneDetail(String phone_seq);    //폰 세부정보 조회(param phone_seq)

}
