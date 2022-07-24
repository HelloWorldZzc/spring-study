import com.test.config.springConfig;
import com.test.domain.account;
import com.test.server.accountServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class app {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(springConfig.class);
        accountServer accountService = ctx.getBean(accountServer.class);

        account ac = accountService.findById(1);
        System.out.println(ac);

    }
}
