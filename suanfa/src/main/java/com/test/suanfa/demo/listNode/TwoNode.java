package com.test.suanfa.demo.listNode;

// 双向链表
public class TwoNode {

   static class Node{
        private Node next;
        private Node last;

        private Integer data;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }

       public Node(Node next, Node last, Integer data) {
           this.next = next;
           this.last = last;
           this.data = data;
       }

       public Integer getData() {
           return data;
       }

       public void setData(Integer data) {
           this.data = data;
       }

       public Node() {
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setData(1);
        node1.setLast(null);

        Node node2 = new Node();
        node2.setLast(node1);
        node2.setData(2);

        node1.setNext(node2);

        Node node3 = new Node();
        node3.setData(3);
        node3.setLast(node2);

        node2.setNext(node3);

        Node node4 = new Node();
        node4.setData(4);
        node4.setLast(node3);

        node3.setNext(node4);
        node4.setNext(null);

        // 反转双链表
        Node newNode = reveseTwoNode(node1);

        Node eachNode = newNode;
        while (eachNode!=null){
            System.out.print(eachNode.getData());
            eachNode = eachNode.getNext();
        }
    }

    private static Node reveseTwoNode(Node head) {
       // 存放临时变量
       Node next = null;
       // 前置节点
       Node pre = null;

       while (head!=null){
          next  = head.next ;
          head.next = pre;
          head.last = next;

          pre = head;
          head = next;

       }
       return  pre;
    }
}
