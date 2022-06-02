package com.reflect_;

public class Dog {

    private int agree = 1;
    public int age = 0;

    public Dog() {

    }
    public Dog(Integer agree) {
        this.agree = agree;
//        this.age = age;
    }

    public void hi() {
        System.out.println("hi 招财猫");
    }

    public void cry() {
        System.out.println("招财猫, 喵喵叫~");
    }
}
