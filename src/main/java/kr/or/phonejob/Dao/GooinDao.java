package kr.or.phonejob.Dao;

import java.util.List;

import kr.or.phonejob.Dto.RegisterGooinDto;

public interface GooinDao {
	
	int registerGooinOk(RegisterGooinDto gdto);
	
	List<RegisterGooinDto> gooinluxury();
	
	List<RegisterGooinDto> gooinbest();
	
	List<RegisterGooinDto> gooinnormal();

}
