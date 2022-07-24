import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class app {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(springConfig.class);
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
