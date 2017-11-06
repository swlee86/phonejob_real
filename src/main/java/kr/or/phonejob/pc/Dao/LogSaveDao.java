package kr.or.phonejob.pc.Dao;

import kr.or.phonejob.pc.Dto.LogSaveDto;

public interface LogSaveDao {

    //로그 저장 처리
    int logsave(LogSaveDto lsdto);
}
