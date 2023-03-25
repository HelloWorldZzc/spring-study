import com.study.controller.userController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class auto_test {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("auto.xml");
        userController userController = ac.getBean("userController", userController.class);
        userController.save();
    }
}
