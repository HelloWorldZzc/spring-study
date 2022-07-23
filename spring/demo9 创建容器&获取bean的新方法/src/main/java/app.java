import com.test.server.bookServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        //创建容器的方式一
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        //创建容器的方式二 这里需要写的是绝对路径
        ApplicationContext ctx=new FileSystemXmlApplicationContext("D:\\Java的IDE\\spring-study\\demo9-创建容器&获取bean的新方法\\src\\main\\resources\\application.xml");
        //获取bean的方式一  需要使用强转
        //bookServer bookService = (bookServer) ctx.getBean("bookServer");
        //获取bean的方式二 在变量后面加上class,就不需要使用强转了
        //bookServer bookService=ctx.getBean("bookServer",bookServer.class);
        //第三种方法 类似于以前的按类型注入,但必须保证IOC容器中该类型对应的bean对象只有一个
        bookServer bookService=ctx.getBean(bookServer.class);
        bookService.save();

    }
}
