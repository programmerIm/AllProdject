package com.test.suanfa.demo.stack;

import java.util.Stack;

// 两个栈实现队列
public class TwoStackToList {

    public static class MyList{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        MyList(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public  void push(Integer value){
            stackPush.push(value);
            // 将push中的数据刷入pop
            pushToPop();
        }

        public Integer pop(){
            pushToPop();
           return stackPop.pop();
        }

        public Integer peek(){
            if(stackPop.isEmpty() && stackPush.isEmpty()){
                throw  new RuntimeException("队列为空");
            }
            pushToPop();
            return stackPop.peek();
        }

        public void pushToPop() {
            // 一定要在pop是空的时候往里刷
            if(stackPop.isEmpty()){
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());

    }
}
