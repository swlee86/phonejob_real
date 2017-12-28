package kr.or.phonejob.smart.s_Service;

import kr.or.phonejob.smart.s_Dao.s_ShopDao;
import kr.or.phonejob.smart.s_Dto.s_ShopDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class s_ShopService implements s_ShopDao {

    @Autowired
    private SqlSession sqlsession;

    @Override
    public List<s_ShopDto> s_selectPhoneList() {
        s_ShopDao sdao = sqlsession.getMapper(s_ShopDao.class);
        List<s_ShopDto> result = sdao.s_selectPhoneList();
        return result;
    }

    @Override
    public s_ShopDto s_selectPhoneDetail(String phone_seq) {
        return null;
    }
}
