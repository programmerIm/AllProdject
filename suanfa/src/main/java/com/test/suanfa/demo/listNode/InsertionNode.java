package com.test.suanfa.demo.listNode;



/**
 * 查找两个链表的公共节点
 * @author liming522
 * @date 2023/1/29 14:49
 */
public class InsertionNode {

    // 两个链表谁先走完，谁从另一个链表的开头走。相遇时即为公共节点。
    public  static OneNode.ListNode  getInsertionNode(OneNode.ListNode node1,OneNode.ListNode node2){
        OneNode.ListNode headA = node1;
        OneNode.ListNode headB = node2;
        while (headA!=headB){
           headA =  headA==null?node2:headA.getNext();
           headB = headB ==null?node1:headB.getNext();
        }
        return headA;
    }
}
