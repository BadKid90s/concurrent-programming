package com.wry.concurrent.thread;

/**
 * <p>
 * 查看线程运行状态
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
public class ThreadStatus {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("running.....");
        }, "t1");

        //获取运行前的状态
        System.out.println("运行前的状态:"+t1.getState());
        //调用start方法
        t1.start();
        t1.start();
        //获取运行后的状态
        System.out.println("运行后的状态:"+t1.getState());
    }
}
