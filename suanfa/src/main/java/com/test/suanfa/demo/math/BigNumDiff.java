package com.test.suanfa.demo.math;
/**
 * 两个大数进行相减
 * 1．将被减数和减数按位对齐，即个位对个位、十位对十位，以此类推。
 * 2．从最低位开始，用被减数减去减数，如果被减数小于减数，则需要向高位借位。
 * 3．在高位借位时，被减数的高位数字减1，借位后被减数的当前位加上10。
 * 4．重复以上步骤，直到所有位数相减完成。如果被减数的位数比减数多，那么剩余的高位数字直接复制到结果中。
 * @author liming522
 */
public class BigNumDiff {
    public static void main(String[] args)  {
        int num1 = 1676857;
        int num2 = 79898696;
        String numStr1 = String.valueOf(num1);
        String numStr2 = String.valueOf(num2);
        String bigStr = numStr1.length() > numStr2.length()?numStr1:numStr2;
        String minStr = numStr1.length()<numStr2.length()?numStr1:numStr2;

        String[] bigArray = numStr1.length()>numStr2.length()?new String[numStr1.length()]:new String[numStr2.length()];
        String[] minArray = numStr1.length() < numStr2.length()?new String[numStr1.length()]:new String[numStr2.length()];
        for (int i =0;i<bigArray.length;i++){
            bigArray[i] = bigStr.charAt(i)+ "";
        }

        for (int i =0;i<minArray.length;i++){
            minArray[i] = minStr.charAt(i)+"";
        }

        String[] result = new String[bigStr.length()];

        int diff = bigArray.length - minArray.length;
        for (int i= bigArray.length-1; i >=0;i--){
            if(i < diff){
                result[i] = String.valueOf(bigArray[i]);
                continue;
            }

            if(Integer.parseInt(bigArray[i])>= Integer.parseInt(minArray[i-diff])){
                result[i] = String.valueOf(Integer.parseInt(bigArray[i]) - Integer.parseInt(minArray[i-diff])) ;
            }else {
                if(i-1>0 && Integer.parseInt(bigArray[i-1])>0){
                    bigArray[i-1]  = String.valueOf(Integer.parseInt(bigArray[i-1]) - 1);
                    result[i] = String.valueOf(Integer.parseInt(bigArray[i])+10 - Integer.parseInt(minArray[i-diff])) ;
                }
            }
        }
        StringBuilder resultStr = new StringBuilder();
        for (String s : result) {
            resultStr.append(s);
        }
        System.out.println(resultStr.toString());
        System.out.println(num2-num1);
    }
}
