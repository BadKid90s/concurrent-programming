package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>
 * 测试线程的常用方法  interrupt 打断park线程
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class InterruptMethod3 {
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
            //再次park
            LockSupport.park();
            log.debug("unpark...");
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();

//        TimeUnit.SECONDS.sleep(1);
//        t1.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
