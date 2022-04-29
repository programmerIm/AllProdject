package com.bonc.springboot.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author: liming522
 * @description:
 * @date: 2022/4/29 12:13 PM
 * @hope: The newly created file will not have a bug
 */
public class PictureDetail2 {
    public static void main(String[] args) throws IOException {
        String path = "/Users/liming522/Desktop/WechatIMG49.jpeg";//导入的图片
        String base = "abcd";//用这里的字符填充图片
        BufferedImage image = ImageIO.read(new File(path));//读取图片，用缓冲对象接收
        // 写到文件中
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/liming522/Desktop/picture.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
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
                    outputStreamWriter.write(" ");//白色换空格，相当于白色背景
                }else {
                    outputStreamWriter.write(base.charAt(index));//有颜色的地方打字符
                }
            }
            outputStreamWriter.write("\n");//每次打印完换行
        }
        outputStreamWriter.close();
        System.out.println("写入成功");
    }
}
