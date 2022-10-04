package com.example.Aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ExampleAfterAspects {

    public final Logger logger = Logger.getLogger(ExampleAfterAspects.class.getName());

    @After("execution(*  printDate())")
    public void afterPrintDate() {
        logger.info("AFTER ADVICE");
        logger.info("This was printed by advice after target execution");

    }
}
