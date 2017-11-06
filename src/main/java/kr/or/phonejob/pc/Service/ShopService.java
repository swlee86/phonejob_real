package kr.or.phonejob.pc.Service;

import kr.or.phonejob.pc.Dao.ShopDao;
import kr.or.phonejob.pc.Dto.ShopDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements ShopDao {

    @Autowired
    private SqlSession sqlsession;

    @Override
    public List<ShopDto> selectPhoneList() {
        ShopDao sdao = sqlsession.getMapper(ShopDao.class);
        List<ShopDto> result = sdao.selectPhoneList();
        return result;
    }

    @Override
    public ShopDto selectPhoneDetail(String phone_seq) {
        return null;
    }
}
