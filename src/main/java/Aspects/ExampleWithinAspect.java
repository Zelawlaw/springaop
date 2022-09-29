package Aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class ExampleWithinAspect {
    public final Logger logger = Logger.getLogger(ExampleWithinAspect.class.getName());

    @Pointcut("within(*.*.*.simpleoperations.*)")
    public void withinSimpleoperations() {
    }
    @Pointcut("within(*.*.*.moresimpleoperations.*)")
    public void withinMoresimpleoperations() {
    }



    @Before("withinSimpleoperations()")
    public void beforeAnyMethodinPackageSimpleOperations(JoinPoint Jp){
        logger.info("Method Signature :"+Jp.getSignature());
        logger.info("Before Advice using Pointcut on Any Setter Method");

    }


    @Around("withinMoresimpleoperations()")
    public Object AroundAnyMethodInPackageMoreSimpleOperations(ProceedingJoinPoint Pjp){
        Object value = null;
        logger.info("Method Signature :"+Pjp.getSignature());
        logger.info("Before Around Advice using Pointcut on Any Public Int Getter Method ");
        logger.info("Proceeding...");
        try{
            value = Pjp.proceed();
        }
        catch(Throwable ex){logger.log(Level.SEVERE,ex.getMessage());}
        logger.info("after Around Advice using Pointcut on Any Public Int Getter Method with value:"+value);
        return value;
    }

}
