package danggialoc.learn.springaopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "danggialoc.learn.springaopdemo")
@EnableAspectJAutoProxy
public class BeanConfig {

}
