package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 创建线程的第二种方式
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */

@Slf4j
public class Thread2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //要执行的任务
                log.debug("runing....");
            }
        };

        //创建一个线程(参数1：要执行的任务，参数2：线程的名字)
        Thread thread = new Thread(runnable,"t2");
        //启动线程
        thread.start();
    }
}
