package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 线程的六种状态
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class ThreadState {
    private static void test1() {
        Thread t1 = new Thread(() -> {  //new
            log.debug("runing......");
        }, "t1");

        Thread t2 = new Thread(() -> {  //running
           while (true){

           }
        },"t2");
        t2.start();

        Thread t3 = new Thread(() -> {  //terminted
            log.debug("runing......");
        },"t3");
        t3.start();

        Thread t4 = new Thread(() -> {  //time_waiting
            synchronized (ThreadState.class) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t4");
        t4.start();

        Thread t5 = new Thread(() -> {  //waiting
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        },"t5");
        t5.start();

        Thread t6 = new Thread(() -> {  //blocked
            synchronized (ThreadState.class) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t6");
        t6.start();

        log.debug("t1 线程的状态： {}",t1.getState());
        log.debug("t2 线程的状态： {}",t2.getState());
        log.debug("t3 线程的状态： {}",t3.getState());
        log.debug("t4 线程的状态： {}",t4.getState());
        log.debug("t5 线程的状态： {}",t5.getState());
        log.debug("t6 线程的状态： {}",t6.getState());

        
    }

    public static void main(String[] args) {
        test1();
    }
}
