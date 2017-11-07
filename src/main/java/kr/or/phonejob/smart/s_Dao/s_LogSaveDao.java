package kr.or.phonejob.smart.s_Dao;

import kr.or.phonejob.smart.s_Dto.s_LogSaveDto;

public interface s_LogSaveDao {

    //로그 저장 처리
    int logsave(s_LogSaveDto lsdto);
}
