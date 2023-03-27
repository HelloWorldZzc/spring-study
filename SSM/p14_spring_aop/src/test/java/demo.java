import com.study.aop_an.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10, 1);
    }
}
