import com.study.mapper.userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class test {
    @Test
    public void test() throws IOException {
        //获取核心配置的文件--->以IO流的方式获取
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //工厂模式--->可以获取到SqlSessionFactory对象，接受的参数为io流的形式
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession 以便对数据库进行操作（是mybatis提供的操作数据库的对象）
        SqlSession sqlSession = build.openSession();
        //通过mapper中的SQL语句进行操作（不常用）
        //int i = sqlSession.insert("com.study.mapper.userMapper.addUser");
        //获取userMapper的代理实现类的对象
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //执行其中的方法
        int i = mapper.addUser();
        System.out.println("结果"+i);
        //事务的提交--->在此需要我们手动去提交事务(build.openSession(true)会自动提交)
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }
}
