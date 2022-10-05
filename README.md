# Spring Aspect Oriented Programming (AOP) Examples

## Description

This project contains examples of how to implement Spring AOP.
The implementations use logger to show how
and where advice is implemented in regard to a target method.
The project also contains tests that can be used to illustrate Spring AOP in action.

## Project setup instructions

## Important Spring AOP terms

- [Digital Ocean Spring AOP tutorials](https://www.digitalocean.com/community/tutorials/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations)
  by Pankaj has a pretty exhaustive and descriptive list of terms used in Spring AOP, have a look at that.

## Ways to see Spring AOP in action in the project

### 1) Tests

The project has a number of tests that illustrate how Aspects, advice and pointcuts work and their effect in program
execution.
Let's look at such a test i.e. the **_addsomenumbers()_**  method in **_
com.example.springaop.simpleops.SimpleOperationsTest_** class.

First, an AspectJProxyFactory object is instantiated.

```sh
    AspectJProxyFactory factory;
```

The factory object is then assigned to a new AspectJProxyFactory with SimpleOperationsImpl() as the target object
An aspect is added to the factory object, in this case **_ExampleAnnotationAspect.class_**.
A proxy of the interface is then created from the factory object.
The proxy will serve up the same methods as the interface. The advice will then be applied before delegating to the
target object for execution of the target method.

```sh
  @Test
    @DisplayName("Testing Example Annotation Aspect with annotated method")
    void addsomenumbers() {
        factory = new AspectJProxyFactory(new SimpleOperationsImpl());
        factory.addAspect(ExampleAnnotationAspect.class);
        SimpleOperations proxy = factory.getProxy();
        int result = proxy.addsomenumbers(456, 37);
        assertEquals(493, result, "It should Return 493");
    }
```

In the com.example.Aspects.ExampleAnnotationAspect class, we have an Around advice on an annotation pointcut.
The aspect calculated the time taken to execute the target method.
![](otherresources/Example%20Annotation%20Aspect.png)

The annotation in question is **_com.example.springaop.annotations.MethodTimeCalculator_** which is defined as
shown below:

```sh
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodTimeCalculator {
}
```

An implementation of the annotation is as shown below:
![](otherresources/MethodTimeCalculator%20annotation%20implementation.png)

To run the test to view the effect of this Aspect, run the following at the project folder on the command line

```sh
./gradlew  test --tests "com.example.springaop.simpleops.SimpleOperationsTest.addsomenumbers"
```
As shown below, the logger in the aspect depicts the starting and stopping of the stopwatch
![](otherresources/test%20run%20result.png)

Below are other Tests and their commands

##### Test Before Advice

```sh
./gradlew test --tests "com.example.springaop.simpleops.PrintSomethingTest.testBeforeAspect"
```

##### Test After Advice

```sh
./gradlew test --tests "com.example.springaop.simpleops.PrintSomethingTest.testAfterAspect"
```

##### Test Within Pointcut

```sh
./gradlew test --tests "com.example.springaop.moresimpleops.MoreSimpleOperationsTest.getSetGetName"
```

##### Test GetterSetter Pointcut

```sh
./gradlew test --tests "com.example.springaop.pojos.AnotherPoJoTest.getSetGetName"
```

```sh
./gradlew   test --tests "com.example.springaop.pojos.AnotherPoJoTest.getSetGetYearsWorked"
```

##### Test Specific Class Pointcut

```sh
./gradlew  test --tests "com.example.springaop.pojos.SimplePoJoTest.getSetName"
```

##### Test Within Pointcut

```sh
./gradlew  test --tests "com.example.springaop.simpleops.SimpleOperationsTest.getSetGetName"
```

### 2) APIs

This will use the JDK dynamic proxy as opposed to the tests where we were creating our own
The same annotation aspect can be seen in action in the addSomenumbers POST method located in the com.example.api.ApiSimpleOperationsResource class

## References

The following resources were used in the research of this project

- [Baeldung spring-aop](https://www.baeldung.com/spring-aop)
- [Spring Framework AOP documentation](https://docs.spring.io/spring-framework/docs/2.5.5/reference/aop.html)
- [Digital Ocean Spring AOP tutorials](https://www.digitalocean.com/community/tutorials/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations)
- [Logging methods with custom annotation in Spring AOP by Kaan Çetin](https://www.digitalocean.com/community/tutorials/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations)
- [Java Annotations](https://docs.oracle.com/javase/1.5.0/docs/guide/language/annotations.html)
- [Log the method execution time using AOP for a spring boot application. By Krushna Dash](https://krushna-dash.medium.com/log-the-method-execution-time-using-aop-for-a-spring-boot-application-c90e85b4d3b9)

## License

[MIT License](https://github.com/nishanths/license/blob/master/LICENSE)