import com.study.mapper.userMapper;
import com.study.pojo.user;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void test_add() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int i = mapper.addUser();
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void test_up(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int i = mapper.updateUser();
        System.out.println(i);
    }
    @Test
    public void test_delete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        int i = mapper.delete();
        System.out.println(i);
    }
    @Test
    public void test_show_id1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user user = mapper.show_id1();
        System.out.println(user);
    }
    @Test
    public void test_show_all(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<user> users = mapper.show_all();
        users.forEach((user -> {
            System.out.println(user);
        }));
    }
}
