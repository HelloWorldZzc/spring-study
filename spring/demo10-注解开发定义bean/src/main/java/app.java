import com.test.dao.bookDao;
import com.test.server.bookServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void main(String[] args) {
        //一个最基本的spring案例,控制反转,使用最基本的配置而不是标注
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        //bookService中的相关配置
        bookServer bookService = (bookServer) ctx.getBean("bookServer");
        bookService.save();

        //在dao中的相关配置文件信息
        bookDao book=ctx.getBean(bookDao.class);
        book.save();

    }
}
