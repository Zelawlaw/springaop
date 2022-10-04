package com.example.springaop.simpleoperations;

import com.example.Aspects.ExampleAfterAspects;
import com.example.Aspects.ExampleAroundAspects;
import com.example.Aspects.ExampleBeforeAspects;
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
        factory.addAspect(new ExampleBeforeAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.printDate();

    }

    @Test
    @DisplayName("Testing After Aspect")
    public void testAfterAspect() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAfterAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.printDate();

    }

    @Test
    @DisplayName("Testing Around Aspect")
    public void testAroundAspect() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAroundAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.printInfo();

    }

    @Test
    @DisplayName("Testing Around Aspect with Arguments")
    public void testAroundAspectWithArguments() {

        factory = new AspectJProxyFactory(printSomething);
        factory.addAspect(new ExampleAroundAspects());
        PrintSomething proxy = factory.getProxy();
        proxy.concatenate("lolo", "0712******", "Westlands");

    }

}