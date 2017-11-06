package kr.or.phonejob.pc.Service;

import kr.or.phonejob.pc.Dto.LogSaveDto;
import kr.or.phonejob.pc.Dao.LogSaveDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSaveService implements LogSaveDao {

    @Autowired
    private SqlSession sqlSession;


    @Override
    public int logsave(LogSaveDto lsdto) {
        LogSaveDao lsdao = sqlSession.getMapper(LogSaveDao.class);
        int result = lsdao.logsave(lsdto);
        return result;
    }
}
