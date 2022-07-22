import com.test.server.bookServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        //一个最基本的spring案例,控制反转,使用最基本的配置而不是标注
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        bookServer bookService = (bookServer) ctx.getBean("bookServer");
        bookService.save();
        //关闭的一种方式,要是运行结束,Java的虚拟机直接关闭,是看不到这个现象的
        //ctx.close();
        //这同样也是能是bean对象销毁的方式
        ctx.registerShutdownHook();

    }
}
