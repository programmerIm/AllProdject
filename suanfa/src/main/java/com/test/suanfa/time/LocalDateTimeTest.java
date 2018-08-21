package com.test.suanfa.time;

import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/8/21   18:18
 */
public class LocalDateTimeTest {
    @Test
   public  void test1(){
    Instant ins = Instant.now();  //默认使用 UTC 时区
		System.out.println(ins);

    OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		System.out.println(ins.getNano()); //纳秒

    Instant ins2 = Instant.ofEpochSecond(5); //加5秒
		System.out.println(ins2);
    }

    @Test
    public void test2(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        System.out.println(ld2);

        LocalDateTime ldt3 = ld2.plusYears(20);//加20年
        System.out.println(ldt3);

        LocalDateTime ldt4 = ld2.minusMonths(2);//减两个月
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    @Test
    public void test7(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
    }
}
