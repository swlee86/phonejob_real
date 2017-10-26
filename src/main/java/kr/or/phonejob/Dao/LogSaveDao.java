package kr.or.phonejob.Dao;

import kr.or.phonejob.Dto.LogSaveDto;

public interface LogSaveDao {

    //로그 저장 처리
    int logsave(LogSaveDto lsdto);
}
