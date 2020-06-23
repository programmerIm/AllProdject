package com.test.suanfa.demo.listNode;

import java.util.List;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/6/20 8:11
 */
public class KNode {
    private static class ListNode {
        private int data;
        private ListNode next;

        ListNode() {
        }

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        int length = 0;
        ListNode  first = head;
        while(first.next!=null){ //求出链表总长度
            first = first.next;
            length +=1;
        }
        ListNode second = head;
        for(int i =1;i<=length-k+1;i++){
            second = second.next;
        }
        return second;
    }
        public static void main(String[] args) {
           ListNode head = new ListNode();
            ListNode a =  new ListNode(1);
            ListNode b = new ListNode(2);
            ListNode c = new  ListNode(3);
            head.next = a;
            a.next = b;
            b.next = c;
            System.out.println(FindKthToTail(head,2).data);
        }
}
