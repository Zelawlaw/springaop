package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootApplication
public class SpringaopApplication {

    private static final Logger logger = Logger.getLogger(SpringaopApplication.class.getName());
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringaopApplication.class, args);
        }
        catch(Exception Ex){
            logger.log(Level.SEVERE,Ex.getMessage(),Ex);
        }
    }

}
