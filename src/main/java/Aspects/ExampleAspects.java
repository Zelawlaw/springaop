package Aspects;


import com.example.springaop.simpleoperations.PrintSomething;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class ExampleAspects {
    public final Logger logger = Logger.getLogger(ExampleAspects.class.getName());
    @Before("execution(public void printDate())")
public void beforePrintDate(){

logger.info("This was printed by advice!");

}


}
