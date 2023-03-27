import com.study.contoller.userController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    @Test
    public void demo1(){
        ClassPathXmlApplicationContext a = new ClassPathXmlApplicationContext("ann.xml");
        userController bean = a.getBean(userController.class);
        bean.say();
    }
}
