package com.example.demo.testModels;


import java.math.BigDecimal;

public class Person2 {
    private String name;// 姓名
    private BigDecimal salary;// 工资

    public Person2(String name, BigDecimal salary) {
        this.salary = salary;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
