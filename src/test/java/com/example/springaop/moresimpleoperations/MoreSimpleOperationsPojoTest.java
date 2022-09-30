package com.example.springaop.moresimpleoperations;


import Aspects.ExampleWithinAspect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoreSimpleOperationsPojoTest {

    private final Logger logger = Logger.getLogger(MoreSimpleOperationsPojoTest.class.getName());
    @Autowired
    MoreSimpleOperationsPojo moreSimpleOperationsPojo;
    AspectJProxyFactory factory;

    @Test
    @DisplayName("Testing ExampleGetterSetterAspect with any getter and setter")
    void getSetGetName() {
        factory = new AspectJProxyFactory(moreSimpleOperationsPojo);
        factory.addAspect(new ExampleWithinAspect());
        MoreSimpleOperationsPojo proxy = factory.getProxy();
        proxy.setSomevar("Zelawlaw");

        assertEquals("Zelawlaw", proxy.getSomevar(), "It should Return Zelawlaw");
    }

}