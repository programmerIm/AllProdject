package com.bonc.springboot.utils;

import java.util.Random;

/**
 * @author:liming
 * @Description: 生成六位随机数
 * @Date:create in 2018/6/21   14:48
 */
public class RandomHelper {

    public String genSixNumber(){

        // 随意置换数据
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);  //指定生成数字的范围
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }

        // 获取六位随即数
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result = result * 10 + array[i];
        }

        // 如果长度不够六位则重新生成
        String random = String.valueOf(result);
        if (random.length() != 6) {
            return genSixNumber();
        }

        // 返回结果
        return String.valueOf(result);
    }
}
