package com.ukma.entity;

public class BrokenStudent {

    private String name;
    private Integer age;

    public BrokenStudent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        return Math.random() < 0.5;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(System.currentTimeMillis()).intValue();
    }

    @Override
    public String toString() {
        return "BrokenStudent(" +
               "name: '" + name + '\'' +
               ", age: " + age +
               ')';
    }
}
