import com.study.mapper.specialMapper;
import com.study.pojo.user;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class specialTest {
    @Test
    public void getUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        specialMapper mapper = sqlSession.getMapper(specialMapper.class);
        List<user> a = mapper.getUserByLike("a");
        System.out.println(a);
    }
    @Test
    public void deleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        specialMapper mapper = sqlSession.getMapper(specialMapper.class);
        mapper.deleteMoreUser("3,4");

    }

    @Test
    public void setTableName(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        specialMapper mapper = sqlSession.getMapper(specialMapper.class);
        List<user> tb_user = mapper.setTableName("tb_user");
        System.out.println(tb_user);

    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        specialMapper mapper = sqlSession.getMapper(specialMapper.class);
        user user = new user(0, "1", "2");
        mapper.insertUser(user);
        System.out.println(user);
    }

}
