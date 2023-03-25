import com.study.pojo.scope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class scope_test {
    static ApplicationContext ac = new ClassPathXmlApplicationContext("bean_scope.xml");

    @Test
    public void test1(){
        //单例模式下-->创建对象的时机--->在IOC获取容器初始化时候就创建了
        scope scope1 = ac.getBean("scope1", scope.class);
        scope scope2 = ac.getBean("scope1", scope.class);
        System.out.println(scope1==scope2);

    }

    @Test
    public void test2(){
        //多例模式下---->创建对象的时机--->在获取bean时
        scope scope1 = ac.getBean("scope2", scope.class);
        scope scope2 = ac.getBean("scope2", scope.class);
        System.out.println(scope1==scope2);

    }
}
