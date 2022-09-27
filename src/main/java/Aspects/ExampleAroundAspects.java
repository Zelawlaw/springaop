package Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class ExampleAroundAspects {

    public final Logger logger = Logger.getLogger(ExampleAroundAspects.class.getName());

    @Around("execution(*  printInfo())")
    public Object aroundPrintInfo(ProceedingJoinPoint proceedingJP) {
        logger.info("AROUND ADVICE");
        Object value = null;
        logger.info("This was printed in around advice before proceed");
        logger.info("method signature :" + proceedingJP.getSignature());
        try {
            value = proceedingJP.proceed();
        } catch (Throwable e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        logger.info("This was printed in around advice after proceed");

        return value;
    }

    @Around("execution(public String concatenate(..))")
    public Object aroundConcatenate(ProceedingJoinPoint proceedingJP) {
        logger.info("AROUND ADVICE with Args");
        Object value = null;
        logger.info("This was printed in around advice before proceed");
        logger.info("method signature :" + proceedingJP.getSignature());
        Object[] arguments = proceedingJP.getArgs();
        Iterator<Object> iter = Arrays.stream(arguments).iterator();
        int i = 0;
        while (iter.hasNext()) {
            logger.info("arg :" + (i++) + " value: " + iter.next());
        }

        try {
            value = proceedingJP.proceed();
        } catch (Throwable e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        logger.info("This was printed in around advice after proceed");
        logger.info("Value returned :" + value);
        return value;
    }

}
