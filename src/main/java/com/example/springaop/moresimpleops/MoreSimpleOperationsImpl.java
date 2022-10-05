package com.example.springaop.moresimpleops;

import org.springframework.stereotype.Service;

@Service
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
