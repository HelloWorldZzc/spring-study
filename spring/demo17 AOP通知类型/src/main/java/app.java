import com.test.config.springConfig;
import com.test.dao.bookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(springConfig.class);
        bookDao bookdao=ctx.getBean(bookDao.class);
        bookdao.save();
        System.out.println("-----华丽的分割线-----");
        int b= bookdao.update(100);
        System.out.println(b);
    }
}
