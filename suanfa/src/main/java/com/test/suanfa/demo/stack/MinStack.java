package com.test.suanfa.demo.stack;



import java.util.Stack;

// 利用两个现成栈对象构造min栈
public class MinStack {
    public static class MyStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    MyStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer value){
        // 首先先确定min栈是不是空的，是空的可以直接压入
        if(minStack.isEmpty()){
            minStack.push(value);
        }else {
            Integer minValue = minStack.peek();
            if(minValue > value){
                minStack.push(value);
            }else {
                minStack.push(minValue);
            }
        }
        dataStack.push(value);
    }

    public Integer pop(){
        if(dataStack.isEmpty()){
            throw  new RuntimeException("栈空了");
        }
        minStack.pop();
        return   dataStack.pop();
    }

    public Integer getMin(){
        if(minStack.isEmpty()){
            throw  new RuntimeException("栈空了，没有最小值");
        }
        return minStack.peek();
    }
  }
}
