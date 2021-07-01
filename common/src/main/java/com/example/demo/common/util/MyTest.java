package com.example.demo.common.util;

import com.example.demo.common.exception.SysException;
import com.example.demo.common.exception.ValException;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Author :tanjm
 * Date:  2021/6/23
 * Desc:
 */
public class MyTest {
    private static ExecutorService EXECUTOR_POOL = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    private static Long lock = 1L;
    private static long time = 0;

    /*public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            EXECUTOR_POOL.execute(() -> {
                Random random = new Random();
                Long s1 = random.nextLong();
                Long s2 = Long.valueOf(s1);
                *//*long st = System.currentTimeMillis();
                String msg = "";
                try {
                    aVoid(0, 6000);
                } catch (Exception e) {
                    msg = e.getMessage();
                }
                long en = System.currentTimeMillis();
                long _t = en - st;
                synchronized (lock) {
                    time += _t;
                }*//*
                System.out.println(s1 + "-" + s2 + "-->> "+(s1==s2));
                //System.out.println(s1==s2);
                //System.out.println(st + "-->>" + en + " " + Thread.currentThread().getName() + "：当前线程耗时：" + _t + ",总耗时：" + time + "," + msg);
            });
        }
        //耗时：4846,current:1000,max:1000
        //耗时：4819,current:1000,max:1000
        //耗时：4763,current:1000,max:1000
        //耗时：4936,current:1000,max:1000
    }*/

    public static void aVoid(int current, int max) throws InterruptedException {
        long st = System.currentTimeMillis();
        current++;
        if (current == max) {
            //throw new ValException("current:" + current + ",max:" + max);
            return;
        } else {
            //Random random = new Random();
            //Thread.sleep(10);
            long en = System.currentTimeMillis();
            //System.out.println(en - st);
            aVoid(current, max);
        }
    }
}
