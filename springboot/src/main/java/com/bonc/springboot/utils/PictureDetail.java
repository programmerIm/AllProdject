package com.bonc.springboot.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @auther :liming
 * @Description: 打印到控制台
 * @Date: create in 2020/2/21 14:30
 */
public class PictureDetail {
        public static void main(String[] args) throws IOException {
            String path = "/Users/liming522/Desktop/WechatIMG49.jpeg";//导入的图片
            String base = "abcd";//用这里的字符填充图片
            BufferedImage image = ImageIO.read(new File(path));//读取图片，用缓冲对象接收
            //两层循环，遍历图片
            //第一层
            for (int y = 0; y < image.getHeight(); y++) {//先竖，再横
                //第二层
                for (int x = 0; x < image.getWidth(); x++) {
                    int color = image.getRGB(x, y);//得到当前点的颜色值
                    int r=(color>>16)&0xff;
                    int g=(color>>8)&0xff;
                    int b=color&0xff;
                    float gray = 0.299f * r + 0.578f * g + 0.114f * b;//灰度值计算
                    int index = Math.round(gray * (base.length()) / 255);
                    if(index>=base.length()) {
                        System.out.print(" ");//白色换空格，相当于白色背景
                    }else {
                        System.out.print(base.charAt(index));//有颜色的地方打字符
                    }
                }
                System.out.println();//每次打印完换行
            }
        }

}
