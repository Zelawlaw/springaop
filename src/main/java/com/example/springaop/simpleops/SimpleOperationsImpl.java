package com.example.springaop.simpleops;

import com.example.springaop.annotations.MethodTimeCalculator;
import org.springframework.stereotype.Component;

@Component
public class SimpleOperationsImpl implements SimpleOperations {

    String somevar;

    public SimpleOperationsImpl() {
    }

    public String getSomevar() {
        return somevar;
    }

    public void setSomevar(String somevar) {
        this.somevar = somevar;
    }


    @MethodTimeCalculator
    public int addsomenumbers(int a, int b) {
        return a + b;
    }
}
