package com.example.springaop.simpleoperations;


import org.springframework.stereotype.Component;

@Component
public class SimplePoJo {


    private String name;
    private int age;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected String getSubject() {
        return subject;
    }

    protected void setSubject(String subject) {
        this.subject = subject;
    }
}
