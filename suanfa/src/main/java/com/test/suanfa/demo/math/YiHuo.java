package com.test.suanfa.demo.math;

/**
 *  寻找出现是奇数次的两个数
 * @author liming522
 * @date 2023/1/9 17:17
 * @return null
 */
public class YiHuo {
    public static void main(String[] args) {

        int[]  arry = {1,3,4,4,2,2};
        find(arry);
    }

    public static  void find(int[] arry){
        Integer  eor = 0;
        for (int i=0;i<arry.length;i++){
             eor ^= arry[i];
        }

        // eor != 0 代表至少某几位为1
        // 找到第一个为1的二进制数
        Integer findOne = ((~eor)+1)&eor;

        Integer resultA = 0 ;
        for (int i =0; i<arry.length;i++){
            if((arry[i] & findOne) !=0){
                resultA ^= arry[i];
            }
        }

        Integer resultB = resultA^eor;
        System.out.println("resultA:"+resultA+",resultB:" + resultB);
    }
}
