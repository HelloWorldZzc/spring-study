import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//使用这个表示符,表示这个类为配置文件的类
@Configuration
//这个标识,表示扫描的相关文件
@ComponentScan("com.test")
public class springConfig {
}
