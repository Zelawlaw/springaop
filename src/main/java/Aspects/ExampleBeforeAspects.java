package Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ExampleBeforeAspects {

    public final Logger logger = Logger.getLogger(ExampleBeforeAspects.class.getName());

    @Before("execution(public void printDate())")
    public void beforePrintDate() {
        logger.info("BEFORE ADVICE");
        logger.info("This was printed by advice before target execution!");

    }
}
