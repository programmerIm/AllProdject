package com.test.suanfa.demo.stack;


/**
 * 数组转成队列
 * @author liming522
 * @date 2023/1/31 14:48
 */
public class ArrayToList {

    public static class MyList{

        private Integer[] arry;
        private Integer size;
        private Integer pushI;
        private Integer popI;
        private Integer limit;

        MyList(Integer limit){
            arry = new Integer[limit];
            size = 0;
            pushI = -1;
            popI = -1;
            this.limit = limit;
        }

        public Integer pop(){
            if(size<=0){
                throw  new RuntimeException("队列空了");
            }
            popI = getIndex(popI);
            size--;
            return arry[popI];
        }

        public void push(Integer value){
            if(size>=limit){
                throw  new RuntimeException("队列满了");
            }

            size ++;
            arry[pushI] = value;
            pushI = getIndex(pushI);
        }

        // 环形数组,如果到末尾从头开始
        public Integer getIndex(Integer index){
            return  index < limit -1? index +1 :0;
        }


    }

    public static void main(String[] args) {
        MyList myStack = new MyList(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);


        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.pop();
    }
}
