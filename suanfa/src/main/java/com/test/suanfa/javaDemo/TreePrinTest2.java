package com.test.suanfa.javaDemo;

import java.util.ArrayList;

/**
 * @auther :liming
 * @Description:把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @Date: create in 2020/4/19 23:14
 */
public class TreePrinTest2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
      ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
            if(pRoot==null) {
                return out;
            }
            ArrayList<TreeNode> queue = new ArrayList<TreeNode>(); //用一个辅助队列来进行层次遍历
            ArrayList<Integer> in = new ArrayList<Integer>();//每层
            queue.add(pRoot);
            //用start和end来区分不同的层
            int start=0;
            int end = 1;//每层节点的数量
            while(queue.size()>0){
                TreeNode temp=queue.remove(0);
                in.add(temp.val);
                start++;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                //如果相等的话，这一层就完事了，那么就重新设定start和end
                if(start==end){
                    end = queue.size();
                    start = 0;
                    out.add(in);
                    //这个地方注意一下不能写ArrayList<Integer> in=new ArrayList<Integer>();
                    //这样会提示你已经有in对象创建了
                    //但是我没有前面的声明就可以了，我理解应该是让in指向了这个新的对象
                    //而原来认为的是重复创建相同名字的对象
                    in = new ArrayList<Integer>();
                }
            }
            return out;
        }
     ArrayList<ArrayList<Integer>> PrintTest(TreeNode pRoot) {//pRoot根节点
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null){
            return result;
        }else {
          ArrayList<TreeNode>  queue = new ArrayList<>();//存放要遍历的层次所有节点，最初是根节点
          ArrayList<Integer>   levelResult  = new ArrayList<>();//存放每层打印结果
          int start = 0;
          int end = 1;//记录每层节点数目
          queue.add(pRoot);
          while (queue.size()>0){
                TreeNode temp = queue.remove(0);
                levelResult.add(temp.val);
                start++;
                //当下一层放入待遍历的集合中
                if(temp.left!=null){
                    queue.add(temp.left);
                }
              if(temp.right!=null){
                  queue.add(temp.right);
              }
              if(start==end){ //当每层结束时，进行重新赋值
                  end = queue.size();//将一层存在的节点数赋予end
                  start = 0;
                  result.add(levelResult);
                  levelResult = new ArrayList<>();
              }
          }
        }
        return  result;
    }

}
