package com.bonc.springboot.entity.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/11 21:17
 */
public class ZookeeperDistrbuteLock  extends  ZookeeperAbstractLock{
    private static final String nodeName = "/test_simple_lock";
    private CountDownLatch countDownLatch ;

    @Override
    boolean tryLock() {
        try {
            if (null == zkClient) return false;
            zkClient.createEphemeral(nodeName);
            return true;
        } catch (Exception e) {
            // 如果失败 直接catch
            return false;
        }
    }

    @Override
    void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            // 节点被删除
            public void handleDataDeleted(String dataPath) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown(); // 计数器为0的情况，await 后面的继续执行
                }
            }
            // 节点被修改
            public void handleDataChange(String dataPath, Object data) throws Exception {
            }
        };

        // 监听事件通知
        zkClient.subscribeDataChanges(nodeName, iZkDataListener);
        // 控制程序的等待
        if (zkClient.exists(nodeName)) {  //如果 检查出 已经被创建了 就new 然后进行等待
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await(); // 等待获取锁---只有当 countDownLatch 为0 时继续往下走
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        //后面代码继续执行
        //为了不影响程序的执行 建议删除该事件监听 监听完了就删除掉
        zkClient.unsubscribeDataChanges(nodeName, iZkDataListener);
    }
}
