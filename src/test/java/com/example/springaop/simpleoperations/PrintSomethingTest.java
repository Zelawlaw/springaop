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
    @DisplayName("Testing Before and After Aspect")
    public void testBeforeAndAfterAspect() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.printDate();

    }

    @Test
    @DisplayName("Testing Around Aspect")
    public void testAroundAspect() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.printInfo();

    }

    @Test
    @DisplayName("Testing Around Aspect with Arguments")
    public void testAroundAspectWithArguments() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.concatenate("lolo","0712******","Westlands");

    }

}