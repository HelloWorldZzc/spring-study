import com.study.aop_an.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo2 {
    @Test
    public void test(){
        //测试xml
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop_xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10, 1);
    }
}
