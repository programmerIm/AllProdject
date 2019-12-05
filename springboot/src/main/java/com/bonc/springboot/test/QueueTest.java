package com.bonc.springboot.test;

import java.util.*;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/7/25 19:52
 */
public class QueueTest {
    public static void main(String[] args) {
//        Queue<String> queue = new LinkedList<String>();
//        queue.offer("hello");
//       // System.out.println(queue.poll());
//        System.out.println(queue.remove());
//        System.out.println(queue.size());


        List<String> list = new ArrayList<>();
        list.add("11111");
        list.add("222222");
        for(String  s: list){
            if(s.equals("11111")){
                list.remove(s);
            }
            System.out.println(s);
        }
      /*  Iterator<String> it = list. iterator();
        while(it. hasNext()){
            if(it.next().equals("11111")){
                it.remove();
            }
            System. out. println(it.next());
        }*/

    }
}
