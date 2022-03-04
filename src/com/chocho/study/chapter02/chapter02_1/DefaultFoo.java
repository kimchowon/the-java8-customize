package com.chocho.study.chapter02.chapter02_1;

public class DefaultFoo implements Foo{

    private String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
