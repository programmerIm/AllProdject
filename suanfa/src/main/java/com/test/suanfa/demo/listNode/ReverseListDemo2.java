package com.test.suanfa.demo.listNode;

/**
 * @auther :liming
 * @Description: 每次都将原第一个结点之后的那个结点放在新的表头后面。
 * 比如1,2,3,4,5
 * 第一次：把第一个结点1后边的结点2放到新表头后面，变成2,1,3,4,5
 * 第二次：把第一个结点1后边的结点3放到新表头后面，变成3,2,1,4,5
 * ……
 * 直到： 第一个结点1，后边没有结点为止。
 * @Date: create in 2020/5/5 19:23
 */
public class ReverseListDemo2 {
    static class ListNode{
        int val; //值
        ListNode next;//下一个节点
        public ListNode(int n) { //构造方法
            val = n;
        }
    }

    public static ListNode reverseListByLocal(ListNode listNode){
            ListNode resultList = new ListNode(-1);//构建一个个初始节点
            resultList.next= listNode;
            ListNode p = listNode; //p为头结点
            ListNode  pnext  =  p.next;
            while (pnext!=null){
                p.next  = pnext.next;
                pnext.next = resultList.next;
                resultList.next = pnext;
                pnext = p.next;
            }
            return resultList.next;
    }
    //打印方法
    public static void printList(ListNode head) {
        if (head == null)
            return;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("反转之前------");
        printList(n1);
        ListNode  resulList =   reverseListByLocal(n1);
        System.out.println("反转之后------");
        printList(resulList);
    }
}
