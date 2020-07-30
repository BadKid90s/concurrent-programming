package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 测试线程的常用方法 interrupt 打断
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
@Slf4j
public class ThreadMethod2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("enter sleep...... ");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("wake up...... ");
            }
        }, "t1");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        log.debug("interrupt...... ");
    }
}
