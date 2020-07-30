package com.wry.concurrent.thread;

import com.wry.concurrent.comm.constans.Constants;
import com.wry.concurrent.comm.util.FileReaderUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * 创建线程调用 run 方法
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
@Slf4j
public class RunMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug(Thread.currentThread().getName());
            FileReaderUtil.read(Constants.FILE_PATH);
        }, "t1");
//        //调用run方法
//        t1.run();
        //调用start方法
        t1.start();
    }
}
