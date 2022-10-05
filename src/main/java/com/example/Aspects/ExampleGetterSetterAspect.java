package com.example.Aspects;


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
public class ExampleGetterSetterAspect {
    public final Logger logger = Logger.getLogger(ExampleGetterSetterAspect.class.getName());

    @Pointcut("execution(* *.*.springaop.*.*.set*(..))")
    public void AnySetterMethod() {
    }

    @Pointcut("execution(* *.*.springaop.*.*.get*(..))")
    public void AnyGetterMethod() {
    }


    @Before("AnySetterMethod()")
    public void beforeSetterMethod(JoinPoint Jp) {
        logger.info("Method Signature :" + Jp.getSignature());
        logger.info("Before Advice using Pointcut on Any Setter Method");

    }

    @Around("AnyGetterMethod()")
    public Object AroundAnyGetterMethod(ProceedingJoinPoint Pjp) {
        Object value = null;
        logger.info("Method Signature :" + Pjp.getSignature());
        logger.info("Before Around Advice using Pointcut on Any Getter Method ");
        logger.info("Proceeding...");
        try {
            value = Pjp.proceed();
        } catch (Throwable ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
        logger.info("after Around Advice using Pointcut on Any Getter Method with value:" + value);
        return value;
    }


}
