package com.test.suanfa.demo.listNode;

/**
 *  双向链表构造栈和队列
 * @author liming522
 * @date  11:38
 * @return null
 */
public class DoubleNode {

    // 链表的基本节点
    public   class Node<T>{
        private T value;
        private Node last;
        private Node next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLast() {
            return last;
        }

        public void setLast(Node last) {
            this.last = last;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node() {
        }
    }

    // 双向链表
    public  class DoubleList<T>{
        private Node<T> head;
        private Node<T> tail;

        public Node<T> getHead() {
            return head;
        }

        public void setHead(Node<T> head) {
            this.head = head;
        }

        public Node<T> getTail() {
            return tail;
        }

        public void setTail(Node<T> tail) {
            this.tail = tail;
        }

        // 从头部添加
        public void addFromHead(Node cur){
            if(head==null){
                head = cur;
                tail = cur;
            }else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        // 从尾部添加

        public void addFromBootom(Node cur){
            if(head == null){
                head = cur;
                tail =cur;
            }else {
                tail.next = cur;
                cur.last = tail;
                tail =cur;
            }
        }

        // 从头部弹出
        public Node popFromHead(){
            if(head == null){
                return null;
            }

            Node cur = head;
            // 如果只有一个节点，弹出后置为空
            if(tail == head){
                head =null;
                tail = null;
            }else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur;
        }

        // 从尾部弹出
        public Node popFromBootom(){
            if(head==null){
                return null;
            }

            Node cur = tail;
            if(tail == head){
                head = null;
                tail = null;
            }else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur;
        }
    }

    public class MyStack<T>{
        private  DoubleList<T> doubleList;

        {
            doubleList = new DoubleList<>();
        }

        public T pop(){
            Node node = doubleList.popFromHead();
            if(node ==null){
                return null;
            }
            return (T) node.getValue();
        }

        public void add(T value){
            Node node = new Node();
            node.setValue(value);
            doubleList.addFromHead(node);
        }
    }


    // 头部出，尾部进  或者是  尾部出，头部进
    public class MyList<T>{
        private  DoubleList<T> doubleList;

        {
            doubleList = new DoubleList<>();
        }

        public T pop(){
            Node node = doubleList.popFromHead();
            if(node == null){
                return null;
            }
            return (T) node.getValue();
        }

        public void add(T value){
            Node node = new Node();
            node.setValue(value);
            doubleList.addFromBootom(node);
        }

    }


    public static void main(String[] args) {
        DoubleNode node = new DoubleNode();
        node.test();
    }

    public void test(){
        // 先进先出
        MyList myList = new  MyList<Integer>();
        myList.add(10);
        myList.add(11);

        System.out.println(myList.pop());
        System.out.println(myList.pop());

        System.out.println("------------------------------------");

        MyStack myStack = new MyStack<Integer>();
        myStack.add(10);
        myStack.add(11);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
