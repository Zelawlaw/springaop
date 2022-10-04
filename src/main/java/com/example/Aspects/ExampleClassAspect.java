package com.example.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ExampleClassAspect {
    public final Logger logger = Logger.getLogger(ExampleClassAspect.class.getName());

    @Pointcut("execution(* *.*.SimplePoJo.*(..))")
    public void AnyMethodInSimplePoJo() {
    }

    @Before("AnyMethodInSimplePoJo()")
    public void beforeSimplePojoPointCut(JoinPoint Jp) {
        logger.info("Method Signature :" + Jp.getSignature());
        logger.info("Before Advice using Pointcut on Any Method in SimplePojo Class");

    }

    @After("AnyMethodInSimplePoJo()")
    public void afterSimplePojoPointCut(JoinPoint Jp) {
        logger.info("Method Signature :" + Jp.getSignature());
        logger.info("After Advice using Pointcut on Any Method in SimplePojo Class");

    }
}
