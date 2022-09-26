package com.example.springaop.simpleoperations;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Component
public class PrintSomething {

    private final Logger logger = Logger.getLogger(PrintSomething.class.getName());

    public void printDate() {

        logger.info("Today's Date :" + new Date());
    }


}
