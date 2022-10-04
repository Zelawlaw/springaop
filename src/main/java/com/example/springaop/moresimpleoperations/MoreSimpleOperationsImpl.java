package com.example.springaop.moresimpleoperations;

import org.springframework.stereotype.Component;

@Component
public class MoreSimpleOperationsImpl implements MoreSimpleOperations {

    String somevar;

    public MoreSimpleOperationsImpl() {

    }

    public String getSomevar() {
        return somevar;
    }

    public void setSomevar(String somevar) {
        this.somevar = somevar;
    }
}
