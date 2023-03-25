import com.study.pojo.user;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class life_test {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("life.xml");
        user user1 = ac.getBean("user1", user.class);
        ac.close();


    }
}
