package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 测试线程的常用方法 Sleep
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
@Slf4j
public class ThreadMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();
        log.debug("t1 线程的状态：{}",t1.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 线程的状态：{}",t1.getState());
    }
}
