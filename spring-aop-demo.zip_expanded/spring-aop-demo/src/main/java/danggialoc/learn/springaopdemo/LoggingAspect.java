package danggialoc.learn.springaopdemo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* danggialoc.learn.springaopdemo.ShoppingCart.checkout(..))")
	public void beforeLogger(JoinPoint jp) {
//		System.out.println(jp.toString());
		//System.out.println(jp.getSignature());
		String arg = jp.getArgs()[0].toString();
//		System.out.println("Before Loggers");
		System.out.println("Before Loggers wwith Argument: " + arg);
	}
	
	@After("execution(* *.*.*.*.checkout(..))")
	public void afterLogger() {
		System.out.println("After Logger");
	}
	
	@Pointcut("execution(* danggialoc.learn.springaopdemo.ShoppingCart.quantity(..))")
	private void afterReturningPointCut() {
	}
	
	@AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
	public void afterReturning(String retVal) {
		System.out.println("After Returning: " + retVal);
	}
	
}
