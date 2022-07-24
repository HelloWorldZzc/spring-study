import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.test")
//限制规定的对象为单例模式
@Scope("singleton")
@PropertySource("config.properties")
public class springConfig {
}
