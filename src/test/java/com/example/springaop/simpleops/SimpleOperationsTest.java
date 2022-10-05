package com.example.springaop.simpleops;


import com.example.Aspects.ExampleAnnotationAspect;
import com.example.Aspects.ExampleWithinAspect;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleOperationsTest {

    private final Logger logger = Logger.getLogger(SimpleOperationsTest.class.getName());

    AspectJProxyFactory factory;


    @Test
    @DisplayName("Testing ExampleGetterSetterAspect with any getter and setter")
    void getSetGetName() {
         factory = new AspectJProxyFactory(new SimpleOperationsImpl());
        factory.addAspect(new ExampleWithinAspect());
        SimpleOperations proxy = factory.getProxy();
        proxy.setSomevar("Zelawlaw");
        assertEquals("Zelawlaw", proxy.getSomevar(), "It should Return Zelawlaw");

    }

    @Test
    @DisplayName("Testing Example Annotation Aspect with annotated method")
    void addsomenumbers() {
         factory = new AspectJProxyFactory(new SimpleOperationsImpl());
        factory.addAspect(ExampleAnnotationAspect.class);
        SimpleOperations proxy = factory.getProxy();
       int result =  proxy.addsomenumbers(456,37);
        assertEquals(493, result, "It should Return 82");
    }


}