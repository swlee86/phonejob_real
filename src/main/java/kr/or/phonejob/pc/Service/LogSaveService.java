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
    public int loghitsave(LogSaveDto lsdto) {
        LogSaveDao lsdao = sqlSession.getMapper(LogSaveDao.class);
        int result = lsdao.loghitsave(lsdto);
        return result;
    }

    @Override
    public int loghstsave(LogSaveDto lsdto) {
        LogSaveDao lsdao = sqlSession.getMapper(LogSaveDao.class);
        int result = lsdao.loghstsave(lsdto);
        return result;
    }
}
