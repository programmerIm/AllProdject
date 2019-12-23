package com.bonc.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/17 15:09
 */
public class MetaspaceDemo {
    static class MetaOom{ }
    public static void main(String[] args) {
      int i = 0;
      try {
        while (true){
            i++;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaOom.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            enhancer.create();
        }
      }catch (Throwable throwable){
          System.out.println("*******经过多少次后发生异常"+i);
          throwable.printStackTrace();
      }
    }
}
