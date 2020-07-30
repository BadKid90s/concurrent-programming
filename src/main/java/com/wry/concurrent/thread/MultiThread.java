package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 演示多个线程并发交替执行
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
@Slf4j
public class MultiThread {
    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                log.debug("running.....");
            }
        },"t1").start();
        
        new Thread(() -> {
            while (true) {
                log.debug("running.....");
            }
        }, "t2").start();
    }
}
