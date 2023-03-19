import com.study.mapper.empMapper;
import com.study.pojo.emp;
import com.study.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

public class TestCache {
    @Test
    public void testGetEmpById() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        empMapper mapper1 = sqlSession1.getMapper(empMapper.class);
        emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        //sqlSession1.clearCache();
        //mapper1.insertEmp(new emp(1, "小红", 25,2));
        emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);
    }
    @Test
    public void testCache2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = build.openSession(true);
        SqlSession sqlSession2 = build.openSession(true);
        empMapper mapper1 = sqlSession1.getMapper(empMapper.class);
        empMapper mapper2 = sqlSession2.getMapper(empMapper.class);
        System.out.println(mapper1.getEmpById(2));
        sqlSession1.close();
        System.out.println(mapper2.getEmpById(2));
    }
}
