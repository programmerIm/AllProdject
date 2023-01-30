package com.test.suanfa.demo.listNode;

/**
 *  移除单链表的指定节点
 * @author liming522
 * @date 2023/1/29 10:47
 * @return null
 */
public class RemoveListNode
{
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
         ListNode   newNode = removeNode(node1, 3);
        while (newNode!=null){
            System.out.print(newNode.getData());
            newNode = newNode.getNext();
        }
    }

    static   class  ListNode{
        private  int data;
        private ListNode next;

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


    // 删除指定节点
    public static ListNode removeNode(ListNode head,int num){
        // 判断第一个是不是要删除的节点，如果第一个不是。那他就是新链表的第一个节点。
        while (head!=null){
            if(head.data !=num){
                break;
            }
            head = head.next;
        }

        ListNode pre = head; // 用于串联
        ListNode cur = head; //用于遍历
        while (cur!=null){
            if(cur.data==num){ //找到对应的值的时候，将其跳过，使前后两节点相连接
              pre.next = cur.next;
            }else {
                pre = cur; // 因为一直遍历的是cur，因此将该值赋予pre
            }
            cur = cur.next;
        }
        return head;
    }
}
