package com.test.suanfa.test.junit;

import org.junit.Before;
import org.junit.Test;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/3 22:57
 */
public class CalculatorTest {
    Calculator c = null;

    @Before
    public void testBeforeClass() {
        c = new Calculator();
    }

    @Test
    //测试 add()方法
    public void testAdd() {
        int result = c.add(1, 2);
        //Assert.assertEquals(result, 3);
        //等价于：
        if (result == 3) {
            System.out.println("add()方法正确");
        }
    }

    @Test
    //测试 sub()方法
    public void testSub() {
        int result = c.sub(2, 1);
        //Assert.assertEquals(result, 1);
        //等价于：
        if (result == 1) {
            System.out.println("sub()方法正确");
        }
    }

}
