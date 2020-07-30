package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>
 * 创建线程的第三种方式
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */

@Slf4j
public class Thread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running.......");
                Thread.sleep(1000);
                return 100;
            }
        });

        //创建一个线程(参数1：要执行的任务，参数2：线程的名字)
        Thread thread = new Thread(task,"t3");
        //启动线程
        thread.start();

        //获取task任务的返回值，主线程会等待task任务完成才会继续执行下边的操作
        Integer integer = task.get();
        log.debug("task 的返回值：{}",integer);
    }
}
