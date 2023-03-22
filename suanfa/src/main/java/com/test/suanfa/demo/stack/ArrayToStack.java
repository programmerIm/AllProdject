package com.test.suanfa.demo.stack;

/**
 * 数组构造栈
 * @author liming522
 * @date 2023/1/31 14:18
 */
public class ArrayToStack {


    public static  class MyStack{
        private Integer[] arry;
        private Integer index;//代表栈顶
        private Integer limit;// 数组的容量

        MyStack(Integer limit){
            arry = new Integer[limit];
            this.limit = limit;
            index = -1;
        }

        public void push(Integer value){
            if(index>=limit-1){
                throw new RuntimeException("栈满了"+value+"放不进去了");
            }
            arry[++index] = value;
        }

        public Integer pop(){
            if(index==-1){
                throw  new RuntimeException("栈空了");
            }
            Integer res = arry[index];
            index--;
            return res;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.pop();
    }
}
