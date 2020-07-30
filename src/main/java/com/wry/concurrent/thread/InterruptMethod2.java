package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试线程的常用方法  interrupt 打断正常状态线程
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class InterruptMethod2 {
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                boolean isInterrupt = Thread.currentThread().isInterrupted();
                if (isInterrupt) {
                    log.debug("被打断了，退出循环");
                    break;
                }
            }
        }, "t1");

        t1.start();

        log.debug("interrupt... ");
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
        log.debug(" 打断状态: {}", t1.isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
