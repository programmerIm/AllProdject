package com.test.suanfa.demo.math;


public class QingWa {
    public static void main(String[] args) {
        String croakOfFrogs = "croakcroa";
        System.out.println(qingWa(croakOfFrogs));
    }

    public static int qingWa(String croakOfFrogs) {
        int[] count = new int[5];
        int result = 0; // 表示最大有几只青蛙再叫
        int now = 0; // 代表当前有几只青蛙再叫

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char msg = croakOfFrogs.charAt(i);
            if (msg == 'c') {
                count[0]++;
                now++;
                result = Math.max(result, now);
            }
            if (msg == 'r') {
                count[1]++;
            }
            if (msg == 'o') {
                count[2]++;
            }
            if (msg == 'a') {
                count[3]++;
            }
            if (msg == 'k') {
                count[4]++;
                now--;
            }
            // 任何时候不满足都不算
            if ( !(count[0] >= count[1] && count[1] >= count[2] && count[2] >= count[3] && count[3] >= count[4] )) {
                return -1;
            }
        }
        // 当还有再叫的退出
        if(now>0){
            return  -1;
        }
        if (count[0]>0&& count[0] == count[1] && count[1] == count[2] && count[2] == count[3] && count[3] == count[4] && count[4] > 0) {
            return result;
        }
        return -1;
    }
}
