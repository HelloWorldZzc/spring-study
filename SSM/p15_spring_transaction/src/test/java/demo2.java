import com.study.pojo.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//使用注解的方式进行，简化相关的操作
@RunWith(SpringJUnit4ClassRunner.class)
//设置配置文件的读取配置文件路径
@ContextConfiguration("classpath:spring-config.xml")
public class demo2 {
    //联想 获取到IOC容器中获取bean的操作
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void add(){
        String sql="insert into tb_user values(null,?,?)";
        int result=jdbcTemplate.update(sql,"zs","666");
        System.out.println(result);
    }
    @Test
    public void select1(){
        String sql = "select * from tb_user where id = ?";
        user emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(user.class), 1);
        System.out.println(emp);
    }
    @Test
    //查询多条数据为一个list集合
    public void testSelectList(){
        String sql = "select * from tb_user";
        List<user> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(user.class));
        list.forEach(emp -> System.out.println(emp));
    }
    @Test
    //查询单行单列的值
    public void selectCount(){
        String sql = "select count(id) from tb_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

}
