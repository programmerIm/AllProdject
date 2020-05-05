package com.test.suanfa.test.junit;

import org.junit.*;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/3 22:58
 */
public class JunitTest {
    public JunitTest() {
        System.out.println("构造函数");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @Before
    public void befor(){
        System.out.println("@Before");
    }

    @Test
    public void test(){
        System.out.println("@Test");
    }

    @Ignore
    public void ignore(){
        System.out.println("@Ignore");
    }

    @After
    public void after(){
        System.out.println("@After");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("@AfterClass");
    }
}