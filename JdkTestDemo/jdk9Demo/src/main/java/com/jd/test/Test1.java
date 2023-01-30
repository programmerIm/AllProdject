package com.jd.test;

/**
 * @author: liming522
 * @description:
 * @date: 2022/11/17 10:38 AM
 * @hope: The newly created file will not have a bug
 */
public class Test1 {


    public static void main(String[] args) {

         Person<String> person = new Person<>(){
                @Override
                public void eat(String s) {
                    super.eat(s);
                }
         };
         person.eat("账单");
    }

}


class Person<T>{

    public  void eat(T t){
        System.out.println(t);
    }
}
