package com.example.springaop.simpleops;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Component
public class PrintSomethingImpl implements PrintSomething {

    private final Logger logger = Logger.getLogger(PrintSomethingImpl.class.getName());

    public void printDate() {

        logger.info("Today's Date :" + new Date());
    }

    public String concatenate(String name, String phonenumber, String Address) {
        return "Concatenate:--> Name :" + name + " PhoneNumber :" + phonenumber + " Address :" + Address;
    }

    public String concatenate2(String FirstName, String phonenumber, String Address) {
        return "Concatenante2:--> FirstName :" + FirstName + " PhoneNumber :" + phonenumber + " Address :" + Address;
    }

    public void printInfo() {

        logger.info(concatenate("Lolo", "+254710xxx43x", "Nairobi Westlands"));
    }


}
