package com.example.springaop.simpleoperations;

import org.springframework.stereotype.Component;

@Component
public class SimpleOperationsPojo {

    String somevar;

    public SimpleOperationsPojo() {
    }

    public String getSomevar() {
        return somevar;
    }

    public void setSomevar(String somevar) {
        this.somevar = somevar;
    }
}
