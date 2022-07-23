import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;

public class app {
    public static void main(String[] args) {
        //一个最基本的spring案例,控制反转,使用最基本的配置而不是标注
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataBase2");
        System.out.println(dataSource);

    }
}
