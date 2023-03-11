import com.study.mapper.userMapper;
import com.study.pojo.user;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class test {
    @Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user userById = mapper.getUserById(2);
        System.out.println(userById);
    }

    @Test
    public void getUserAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<user> userAll = mapper.getUserAll();
        System.out.println(userAll);
    }
    @Test
    public void getIDSum() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        Integer idSum = mapper.getIDSum();
        System.out.println(idSum);
    }
    @Test
    public void getUserTOMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<Map<String, String>> userTOMap = mapper.getUserTOMap();
        System.out.println(userTOMap);
    }

    @Test
    public void getUserTOMap2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        Map<String, Object> userTOMap2 = mapper.getUserTOMap2();
        System.out.println(userTOMap2);
    }
}
