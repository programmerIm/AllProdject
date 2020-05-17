package com.test.suanfa.demo;


/**
 * @auther :liming
 * @Description: 思路是：将链表遍历，从链表头部取出放到新链表头部
 * @Date: create in 2020/5/5 18:48
 */
public class ReverseListDemo1 {
    static class ListNode {
        int val;//节点的值
        ListNode next;//下一个节点

        ListNode(int x) { //节点构造方法
            val = x;
        }
    }

    public static ListNode reverseListByInsert(ListNode listNode) {
        //定义一个带头节点的
        ListNode resultList = new ListNode(-1);
        //循环节点
        ListNode p = listNode;
        while (p != null) {
            //保存插入点之后的数据
            ListNode nextNode = p.next;//当前节点的下一个节点
            p.next = resultList.next; //将结果节点的下一个节点替换
            resultList.next = p;
            p = nextNode; //将下一个节点作为循环变量
        }
        return resultList.next;
    }

    //打印
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
        ListNode resulList = reverseListByInsert(n1);
        System.out.println("反转之后------");
        printList(resulList);
    }
}
