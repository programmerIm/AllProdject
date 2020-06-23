package com.test.suanfa.demo.listNode;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/6/17 22:39
 */
public class StartNode {
    private static class Node{
        private int data;
        private Node next;

        Node(){}
        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    public   static  Node EntryNodeOfLoop(Node pHead) {
            if (pHead == null || pHead.next == null) {
                return null;
            }
            Node fast = pHead.next;
            Node slow = pHead.next.next;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = pHead;
            while (fast != null) {
                if (fast == slow) {
                    return fast;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

    public static void main(String[] args){
        // 构造链表 1->2->3->4->5->6-4;
        Node head = new Node();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = d;
        // 结果
        System.out.println("环节点的入口为:"+EntryNodeOfLoop(head).data);
    }
}
}
