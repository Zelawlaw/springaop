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

    public String concatenate (String name,String phonenumber,String Address){
      return "Name :"+name+" PhoneNumber :"+phonenumber+" Address :"+Address;
    }
    public String concatenate2 (String FirstName,String phonenumber,String Address){
        return "FirstName :"+FirstName+" PhoneNumber :"+phonenumber+" Address :"+Address;
    }
    public void printInfo(){

        logger.info(concatenate("Lolo","+254710xxx43x","Nairobi Westlands"));
    }






}
