package com.wry.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 测试线程的常用方法 使用TimeUnit
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
@Slf4j
public class ThreadMethod3 {
    public static void main(String[] args) throws InterruptedException {
        log.debug("start ......");
        TimeUnit.SECONDS.sleep(1);
        log.debug("end ......");
    }
}
