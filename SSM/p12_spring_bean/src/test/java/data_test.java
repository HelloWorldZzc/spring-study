import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class data_test {
    @Test
    public void test(){
        //检测与数据库连接 是否成功的
        ApplicationContext ac = new ClassPathXmlApplicationContext("data.xml");
        DruidDataSource bean = (DruidDataSource) ac.getBean("dataSource");
        System.out.println(bean);
    }
}
