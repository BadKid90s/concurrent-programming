package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试线程的常用方法 join 等待多个结果
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class JoinMethod2 {
    private static int r1 = 0;
    private static int r2 = 0;

    private static void test1() throws InterruptedException {
        log.debug("开始......");
        Thread t1 = new Thread(() -> {
            log.debug("开始......");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束......");
            r1 = 10;
        }, "t1");

        Thread t2 = new Thread(() -> {
            log.debug("开始......");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束......");
            r2 = 20;
        }, "t2");

        //启动线程
        t1.start();
        t2.start();

        //开始时间
        long start = System.currentTimeMillis();
        log.debug("join begin ......");
        t1.join();
        log.debug("t1 join end ......");
        t2.join();
        log.debug("t2 join end ......");
        //结束时间
        long end = System.currentTimeMillis();
        log.debug("t1 结果为:{},t2 结果为:{},总耗时：{}", r1, r2, end - start);
        log.debug("结束......");
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
