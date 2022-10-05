package com.example.springaop.pojos;

import com.example.Aspects.ExampleGetterSetterAspect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class AnotherPoJoTest {
    private final Logger logger = Logger.getLogger(AnotherPoJoTest.class.getName());
    @Autowired
    AnotherPoJo anotherPoJo;

    @Autowired
    ApplicationContext ctx;

    AspectJProxyFactory factory;

    @Test
    @DisplayName("Testing ExampleGetterSetterAspect with any getter and setter")
    void getSetGetName() {
        factory = new AspectJProxyFactory(new AnotherPoJo());
        factory.addAspect(new ExampleGetterSetterAspect());
        AnotherPoJo proxy = factory.getProxy();
        proxy.setName("Jackson");
        assertEquals("Jackson", proxy.getName(), "It should Return Jackson");
    }

    @Test
    @DisplayName("Testing ExampleGetterSetterAspect with any getter, Setter returning int")
    void getSetGetYearsWorked() {
        factory = new AspectJProxyFactory(new AnotherPoJo());
        factory.addAspect(new ExampleGetterSetterAspect());
        AnotherPoJo proxy = factory.getProxy();
        proxy.setYearsWorked(5);
        proxy.getYearsWorked();
        assertEquals(5, 5, "It should Return 5");
    }


}