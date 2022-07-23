import com.test.server.bookServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用@Component可以更加简单的完成相关bean中的注解开发
 * 当然也能使用  @Controller @Service @Repository 和component的功能是一模一样的,就是这个的话,会更加的好理解
 * 注解开发定义bean还需要一个配置文件的读取(扫描bean的作用)
 * 使用这个纯注解的开发能够省略那些步骤,开发一个类,上面标一个注解表示这个是配置文件,上面表一个配置,表示扫描文件
 */

public class app {
    public static void main(String[] args) {
        //使用这个方式来获取相关的文件件
        ApplicationContext ctx=new AnnotationConfigApplicationContext(springConfig.class);
        bookServer bookService = (bookServer) ctx.getBean("bookServer");
        bookService.save();


    }
}
