package danggialoc.learn.masterclass.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "danggialoc.learn.masterclass.demo")
public class BeanConfig {
	
//	@Bean // Khi định nghĩ Bean thì không cần dùng đến @Component trong class
//	public Doctor doctor() {
//		return new Doctor(null);
//	}
}
