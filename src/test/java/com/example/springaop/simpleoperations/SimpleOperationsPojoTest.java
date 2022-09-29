package com.example.springaop.simpleoperations;

import Aspects.ExampleWithinAspect;
import com.example.springaop.moresimpleoperations.MoreSimpleOperationsPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SimpleOperationsPojoTest {

    private final Logger logger = Logger.getLogger(SimpleOperationsPojoTest.class.getName());
    @Autowired
    SimpleOperationsPojo simpleOperationsPojo;
    AspectJProxyFactory factory;

    @Test
    @DisplayName("Testing ExampleGetterSetterAspect with any getter and setter")
    void getSetGetName() {
        factory = new AspectJProxyFactory(simpleOperationsPojo);
        factory.addAspect(new ExampleWithinAspect());
        SimpleOperationsPojo proxy = factory.getProxy();
        proxy.setSomevar("Zelawlaw");

        assertEquals("Zelawlaw", proxy.getSomevar(),"It should Return Zelawlaw");
    }
}