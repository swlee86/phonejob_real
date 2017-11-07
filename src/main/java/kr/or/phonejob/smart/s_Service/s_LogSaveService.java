package kr.or.phonejob.smart.s_Service;

import kr.or.phonejob.smart.s_Dao.s_LogSaveDao;
import kr.or.phonejob.smart.s_Dto.s_LogSaveDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class s_LogSaveService implements s_LogSaveDao {

    @Autowired
    private SqlSession sqlSession;


    //모바일 접근시 로그 저장 처리
    @Override
    public int logsave(s_LogSaveDto lsdto) {
        s_LogSaveDao lsdao = sqlSession.getMapper(s_LogSaveDao.class);
        int result = lsdao.logsave(lsdto);
        return result;
    }
}
