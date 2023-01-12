package com.test.suanfa.test;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/29 21:56
 */
public class Test {
    public static void main(String[] args) {
       /* int i1 = 10;
        i1++;
        System.out.println(i1);

        int i2 = 10;
        i2++;
        System.out.println(i2);

        int i3 = 10;
        int i4 = i3++;
        System.out.println(i4);

        int i5 = 10;
        int i6 = ++i5;
        System.out.println(i6);

        int i7 = 10;
         i7= ++i7;
        System.out.println(i7); //11

        int i8 = 10;
         i8 = i8++;
        System.out.println(i8); //10

        int i9 = 10;
        int i10 = i9++ + ++i9;
        System.out.println(i10); //10+12=22*/
       testTable();
    }


    public  static  void testTable(){
     /*   int waybillCode = 123456;

        // 逻辑id
        int  logi = waybillCode % 1024 ;

        int ku  =  logi/128 +1 ;


        int table = logi%128 + 1;
        System.out.println("逻辑ID:" + logi);
        System.out.println("库名:" + ku);
        System.out.println("table:"+table);
*/


        int siteCode = 32;
        int duanhao  = siteCode%32+1;
        System.out.println("段号"+duanhao);
        int waybillCode = 123456;
        int duanneibiao = waybillCode%16+1;
        System.out.println("段内表为"+duanneibiao);
        int table = duanhao*32 +duanneibiao+1;
        System.out.println("最终表名位"+table);
    }

}
