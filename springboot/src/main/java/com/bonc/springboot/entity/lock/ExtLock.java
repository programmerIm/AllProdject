package com.bonc.springboot.entity.lock;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/11 21:15
 */
public interface ExtLock {
    //ExtLock基于zk实现分布式锁
    public void  getLock();

    //释放锁
    public void unLock();
}
