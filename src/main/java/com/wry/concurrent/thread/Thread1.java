package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 创建线程的第一种方式 Thread类
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */

@Slf4j
public class Thread1 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                //要执行的任务
                log.debug("runing....");
            }
        };
        //设置线程名字
        thread.setName("t1");
        //启动线程
        thread.start();

        log.debug("main....");

        //java 8 之后使用Lambda
        //创建任务
        Runnable lombdaRunnable = () -> {
            log.debug("lombda runging......");
        };
        //创建线程
        Thread lombdaThead = new Thread(lombdaRunnable, "lombdaThead");
        //启动线程
        lombdaThead.start();

        //再次精简
        new Thread(() -> {
            log.debug("lombda runging......");
        }, "lambdaThread").start();
    }
}
