package com.bonc.springboot.test;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) throws ParseException {
        String date1 = "2023-08-22 16:00:00";
        String date2 = "2023-08-22 18:00:00";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        Demo demo1 = new Demo();
        demo1.setId(1);
        demo1.setUpdateTime(simpleDateFormat.parse(date1));

        Demo demo2 = new Demo();
        demo2.setId(2);
        demo2.setUpdateTime(simpleDateFormat.parse(date1));

        Demo demo3 = new Demo();
        demo3.setId(3);
        demo3.setUpdateTime(simpleDateFormat.parse(date2));

        List<Demo> list = new ArrayList<Demo>();
        list.add(demo1);
        list.add(demo2);
        list.add(demo3);
        System.out.println("当前排序顺序"+ JSON.toJSONString(list));
        // 先是 1 2 3  再然后 3 2 1 当updateTime相同 比较ID 1 2 3 逆反得到 3 2 1
         List<Demo> sortFirst = list.stream().sorted(Comparator.comparing(Demo::getUpdateTime,Comparator.reverseOrder()).thenComparing(Demo::getId,Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println("第一种排序"+JSON.toJSONString(sortFirst)); // 期望输出 3 2 1

        List<Demo> sortSecond = list.stream().sorted(Comparator.comparing(Demo::getUpdateTime).reversed())
                 .sorted().collect(Collectors.toList());
        System.out.println("第二种排序"+JSON.toJSONString(sortSecond)); // 期望输出 3 2 1
    }
}

class Demo{
    private Date updateTime;

    private Integer id;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
