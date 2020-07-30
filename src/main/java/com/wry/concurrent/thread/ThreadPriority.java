package com.wry.concurrent.thread;

/**
 * <p>
 * 设置线程的线程优先级
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (; ; ) {
                System.out.println("---->1 " + count++);
            }
        };
        Runnable task2 = () -> {
            int count = 0;
            for (; ; ) {
//                //调用yield,把CPU执行执行时间交给其他线程
//                Thread.yield();
                System.out.println("        ---->2 " + count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        //t1线程设置最小的线程优先级
        t1.setPriority(Thread.MIN_PRIORITY);
        //t2线程设置最大的线程优先级
        t2.setPriority(Thread.MAX_PRIORITY);
        
        t1.start();
        t2.start();
    }
}
