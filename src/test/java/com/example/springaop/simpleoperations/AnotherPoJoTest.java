package com.example.springaop.simpleoperations;

import Aspects.ExampleClassAspect;
import Aspects.ExampleGetterSetterAspect;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AnotherPoJoTest {
    private final Logger logger = Logger.getLogger(AnotherPoJoTest.class.getName());
    @Autowired
    AnotherPoJo anotherPoJo;

    AspectJProxyFactory factory;
    @Test
    void getSetGetName() {
        factory = new AspectJProxyFactory(anotherPoJo);
        factory.addAspect(new ExampleGetterSetterAspect());
        AnotherPoJo proxy = factory.getProxy();
        proxy.setName("Jackson");
        proxy.getName();
    }


}