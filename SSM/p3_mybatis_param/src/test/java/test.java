import com.study.mapper.userMapper;
import com.study.pojo.user;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class test {
    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user admin = mapper.getUserByUsername("admin");
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user admin = mapper.checkLogin("admin","123456");
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("name","admin");
        map.put("psd","123456");
        user user = mapper.checkLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.insertUser(new user(0,"test_name","test_password"));
        sqlSession.close();
    }

    @Test
    public void insertUserPlus(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.insertUserPlus(new user(0,"test_name1","test_password1"),new user(0,"test_name2","test_password2"));
        sqlSession.close();
    }
    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user admin = mapper.checkLoginByParam("admin", "123456");
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void add(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.add(new user(0,"test_name1","test_password1"),new user(0,"test_name2","test_password2"));
        sqlSession.close();
    }
}
