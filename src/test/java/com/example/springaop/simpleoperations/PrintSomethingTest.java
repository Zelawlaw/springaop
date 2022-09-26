package com.example.springaop.simpleoperations;

import Aspects.ExampleAspects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PrintSomethingTest {

    @Autowired
    PrintSomething printSomething;
    AspectJProxyFactory factory;


    @Test
    @DisplayName("Testing Before Aspect")
    public void testBeforeAspect() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.printDate();

    }
}