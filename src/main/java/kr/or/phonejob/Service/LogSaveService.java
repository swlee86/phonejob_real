package kr.or.phonejob.Service;

import kr.or.phonejob.Dao.LogSaveDao;
import kr.or.phonejob.Dto.LogSaveDto;
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
