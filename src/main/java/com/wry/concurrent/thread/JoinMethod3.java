package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试线程的常用方法 join 有时效的等待
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class JoinMethod3 {
    private static int r1 = 0;

    private static void test1() throws InterruptedException {
        log.debug("开始......");
        Thread t1 = new Thread(() -> {
            log.debug("开始......");
            try {
                //睡2000毫秒
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束......");
            r1 = 10;
        }, "t1");

        //启动线程
        t1.start();

        //开始时间
        long start = System.currentTimeMillis();
        log.debug("join begin ......");
        //只等待1500毫秒
        t1.join(1500);
        log.debug("t1 join end ......");
        //结束时间
        long end = System.currentTimeMillis();
        log.debug("t1 结果为:{},总耗时：{}", r1,  end - start);
        log.debug("结束......");
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
