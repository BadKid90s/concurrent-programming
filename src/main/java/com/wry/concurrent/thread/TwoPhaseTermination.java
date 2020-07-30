package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 利用interrupt实现两阶段停止。
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/28
 */
@Slf4j
public class TwoPhaseTermination {
    private Thread monitor;

    /**
     * 启动监控
     */
    private void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()){
                    log.debug("料理后事。。。。。。");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1); //打断阻塞的线程  会抛异常，打断标记会被重置
                    log.debug("执行监控记录。。。。。。"); //打断正常的线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //再次打断,重新设置打断标记
                    currentThread.interrupt();
                }
            }
        });

        monitor.start();
    }

    /**
     * 停止监控
     */
    private void stop() {
        monitor.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination termination = new TwoPhaseTermination();
        termination.start();

        TimeUnit.SECONDS.sleep(3);
        termination.stop();
    }
}
