package com.company.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author Wenfei.Li
 * @version 1.0.0
 * @date 2022/5/18 14:41
 */
public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before(){
        lock.lock();
        try {
            System.out.println("---before--");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void after(){
        lock.lock();
        try {
            condition.await();
            System.out.println("---after--");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        executorService.execute(awaitSignalExample::after);
        executorService.execute(awaitSignalExample::after);
        executorService.execute(awaitSignalExample::after);
        executorService.execute(awaitSignalExample::before);
    }
}
