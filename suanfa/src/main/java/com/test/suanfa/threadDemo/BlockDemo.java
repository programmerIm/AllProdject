package com.test.suanfa.threadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BlockDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();

        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean isHeldExclusively() {
                return super.isHeldExclusively();
            }
        };
    }
}
