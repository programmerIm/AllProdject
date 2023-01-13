package com.test.suanfa.demo.listNode;

public class OneNode {

  static   class  ListNode{
        private  int data;
        private  ListNode next;

        public ListNode() {
        }

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();

        node1.setData(1);
        node1.setNext(node2);

        node2.setData(2);
        node2.setNext(node3);

        node3.setNext(node4);
        node3.setData(3);

        node4.setData(4);
        node4.setNext(null);

        ListNode nextNode = reseveNode4(node1);

        while (nextNode!=null){
            System.out.print(nextNode.getData());
            nextNode = nextNode.getNext();
        }

    }

    public static ListNode reseveNode(ListNode head){

      ListNode next = null;
      ListNode pre =  null;

      while (head.next !=null){
          next = head.next;
          head.next = pre;
          pre = head;
          head = next;
      }
      head.next = pre;
      return  head;
    }


    // 双指针算法
    public static ListNode reseveNode2(ListNode head){

        ListNode next = null;
        ListNode pre =  null;

        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return  pre;
    }

    // 三指针算法
    public static ListNode reseveNode3(ListNode head){
      // 初始化三个指针
      ListNode pre = null;
      ListNode mid = head;
      ListNode next = head.next;

      while (true){
          // 修改mid节点的指针
           mid.next = pre;

          if(next == null){
              break;
          }

          // 将三个指针向后移动
          pre = mid;
          mid = next;
          next = next.next;
      }

      return mid;
    }

    // 引入新的链表,将旧链表从头结点开始一个个摘除，挂到新链表上
    public static ListNode reseveNode4(ListNode head){
      if(head==null||head.next==null){
          return  head;
      }

      ListNode temp = null;
      ListNode new_head = null;

      while (head!=null){
          temp = head;
          // 将head从链表中摘除
          head = head.next;
          // 将head挂到新的链表上
          temp.next = new_head;
          // 指向新链表的头
          new_head= temp;
      }
      return  new_head;
    }

}
