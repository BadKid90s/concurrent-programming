package com.wry.concurrent.concurrent;

import com.wry.concurrent.comm.constans.Constants;
import com.wry.concurrent.comm.util.FileReaderUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 异步不等待
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/26
 */
@Slf4j
public class Async {

    public static void main(String[] args) {
        //创建一个线程去异步执行，不需要等待执行完毕，就可以执行其他操作
        new Thread(() -> {
            FileReaderUtil.read(Constants.FILE_PATH);
        }).start();

        log.debug("do other things .....");
    }
}
