package com.example.springaop.moresimpleoperations;


import com.example.Aspects.ExampleWithinAspect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoreSimpleOperationsTest {

    private final Logger logger = Logger.getLogger(MoreSimpleOperationsTest.class.getName());
    @Autowired
    MoreSimpleOperations moreSimpleOperations;
    AspectJProxyFactory factory;

    @Test
    @DisplayName("Testing ExampleGetterSetterAspect with any getter and setter")
    void getSetGetName() {
        factory = new AspectJProxyFactory(moreSimpleOperations);
        factory.addAspect(new ExampleWithinAspect());
        MoreSimpleOperations proxy = factory.getProxy();
        proxy.setSomevar("Zelawlaw");

        assertEquals("Zelawlaw", proxy.getSomevar(), "It should Return Zelawlaw");
    }

}