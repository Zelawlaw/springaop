package com.example.springaop.simpleoperations;

import Aspects.ExampleAroundAspects;
import Aspects.ExampleClassAspect;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SimplePoJoTest {
    private final Logger logger = Logger.getLogger(SimplePoJoTest.class.getName());
    @Autowired
    SimplePoJo simplePoJo;

    AspectJProxyFactory factory;

    @Test
    void getSetName() {
        factory = new AspectJProxyFactory(simplePoJo);
        factory.addAspect(new ExampleClassAspect());
        SimplePoJo proxy = factory.getProxy();
        proxy.setName("Lolo");
        assertEquals("Lolo",proxy.getName(),"It should be equal to the name Lolo");
    }
}