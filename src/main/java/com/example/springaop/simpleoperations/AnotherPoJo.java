package com.example.springaop.simpleoperations;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnotherPoJo {

    String name;
    String career;
    int yearsWorked;

    public AnotherPoJo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

    public void setYearsWorked(int yearsWorked) {
        this.yearsWorked = yearsWorked;
    }
}
