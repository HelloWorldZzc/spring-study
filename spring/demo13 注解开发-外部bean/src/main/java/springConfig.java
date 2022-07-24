import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.test")
@Import(com.test.config.jdbcConfig.class)
public class springConfig {
}
