package com.chocho.study.chapter02.chapter02_2;

public abstract class PuppyAbstract implements PuppyInterface {

    @Override
    public void a() {
        System.out.println("a");
    }

    @Override
    public String b() {
        return "b";
    }

    @Override
    public int c() {
        return 1;
    }

    public abstract void d();
}
