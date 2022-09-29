package com.example.springaop.moresimpleoperations;

import org.springframework.stereotype.Component;

@Component
public class MoreSimpleOperationsPojo {

    String somevar;

    public MoreSimpleOperationsPojo() {

    }

    public String getSomevar() {
        return somevar;
    }

    public void setSomevar(String somevar) {
        this.somevar = somevar;
    }
}
