package com.jd.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author: liming522
 * @description:
 * @date: 2022/11/17 3:45 PM
 * @hope: The newly created file will not have a bug
 */
public class Test5 {

    public static void main(String[] args) throws FileNotFoundException {
         FileInputStream inputStream = new FileInputStream("a.text");
        FileOutputStream fileOutputStream = new FileOutputStream("b.text");

        try(inputStream;fileOutputStream) {
            inputStream.transferTo(fileOutputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
