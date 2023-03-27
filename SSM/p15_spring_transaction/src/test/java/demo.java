//使用最传统的方式进行
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class demo {
    @Test
    public void run(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql="insert into tb_user values(null,?,?)";
        int result=jdbcTemplate.update(sql,"zs","666");
        System.out.println(result);
    }
}
