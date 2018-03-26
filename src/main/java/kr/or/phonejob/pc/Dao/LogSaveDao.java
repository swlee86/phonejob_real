package kr.or.phonejob.pc.Dao;

import kr.or.phonejob.pc.Dto.LogSaveDto;

public interface LogSaveDao {

    //조회성 로그 저장 처리
    int loghitsave(LogSaveDto lsdto);

    //처리성 로그 저장 처리
    int loghstsave(LogSaveDto lsdto);
}
