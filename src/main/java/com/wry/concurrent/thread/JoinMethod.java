package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试线程的常用方法 join
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class JoinMethod {
    private static int r = 0;

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
            r = 10;
        },"t1");
        t1.start();
        t1.join();
        log.debug("结果为:{}", r);
        log.debug("结束......");
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
