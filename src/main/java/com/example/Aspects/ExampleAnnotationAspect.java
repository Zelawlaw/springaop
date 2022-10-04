package com.example.Aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

@Aspect
@Component
public class ExampleAnnotationAspect {
    public final Logger logger = Logger.getLogger("Annotation Aspect");


    @Around("@annotation(com.example.springaop.annotations.MethodTimeCalculator)")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        // Get intercepted method details
        String methodName = methodSignature.getName();

        // get Target arguments
        Object[] args = pjp.getArgs();

        // Measure method execution time
        StopWatch stopWatch = new StopWatch();
        logger.info("Starting StopWatch....");
        stopWatch.start();
        Object result = pjp.proceed();
        stopWatch.stop();
        logger.info("Stopped StopWatch");

        // Log method execution time
        logger.info("sum of " + args[0] + " + " + args[1] + " is :" + result + " time taken:" + stopWatch.getTotalTimeNanos() + "  ns");

        return result;

    }

}
