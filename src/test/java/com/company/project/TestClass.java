package com.company.project;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author Wenfei.Li
 * @version 1.0.0
 * @date 2022/5/17 16:02
 */
public class TestClass {

    static SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(true);


    @AllArgsConstructor
    static class PutThread implements Runnable{
        int i;
        @SneakyThrows
        @Override
        public void run() {
            synchronousQueue.put(i);
            System.out.println("putThread "+i+" end");
        }
    }
    static class TakeThread implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("takeThread take: "+synchronousQueue.take());
        }
    }

    public static void main1(String[] args) throws InterruptedException {
        AtomicInteger put = new AtomicInteger(0);
        AtomicInteger take = new AtomicInteger(0);
        for (int i = 1; i <=3; i++) {
            new Thread(new PutThread(i)).start();
            take.getAndIncrement();
            System.out.println("put-----"+take);
            Thread.sleep(2000);
        }
        for (int i = 1; i <=3 ; i++) {
            new Thread(new TakeThread()).start();
            put.getAndIncrement();
            System.out.println("take-----"+put);
            Thread.sleep(1000);
        }

    }
    static class User{
        private String name;
        private transient String realName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("1213");
        user.setRealName("111");
        System.out.println(JSON.toJSONString(user));
    }

}
