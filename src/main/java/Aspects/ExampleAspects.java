package Aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class ExampleAspects {
    public final Logger logger = Logger.getLogger(ExampleAspects.class.getName());

    @Before("execution(public void printDate())")
    public void beforePrintDate() {
        logger.info("BEFORE ADVICE");
        logger.info("This was printed by advice before target execution!");

    }

    @After("execution(*  printDate())")
    public void afterPrintDate() {
        logger.info("AFTER ADVICE");
        logger.info("This was printed by advice after target execution");

    }

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

        return value;
    }


    @Around("execution(public String concatenate(..)) && args(FirstName,..)")
    public Object aroundConcatenateWithSpecificArgs(ProceedingJoinPoint proceedingJP,String FirstName) {
        logger.info("AROUND ADVICE with Args,FirstName :"+FirstName);
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

        return value;
    }



}
