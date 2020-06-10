package com.bonc.springboot.demo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/3 10:08
 */
class User{
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int age;
     String name;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class AbaDemo {
    public static void main(String[] args) {
        User z3 = new User(22,"z3");
        User li4 = new User(21,"li4");
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.toString());
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.toString());
    }
}
