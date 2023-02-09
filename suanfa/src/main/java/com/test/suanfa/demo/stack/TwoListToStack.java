package com.test.suanfa.demo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * @author liming522
 * @date 2023/2/7 15:41
 */
public class TwoListToStack {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoListToStack(){
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(Integer value){
        data.add(value);
    }

    public Integer poll(){
        while (data.size()>1){
            help.offer(data.poll());
        }
        Integer  ans = data.poll();

        Queue<Integer> temp = data;
        data = help;
        help = temp;
        return ans;
    }

    public Integer peek(){
        while (data.size()>1){
            help.offer(data.poll());
        }
        Integer  ans = data.peek();

        Queue<Integer> temp = data;
        data = help;
        help = temp;
        data.offer(ans);
        return ans;
    }


}
