package com.wry.concurrent.concurrent;

import com.wry.concurrent.comm.constans.Constants;
import com.wry.concurrent.comm.util.FileReaderUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * 同步等待
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/26
 */
@Slf4j
public class Sync {

    public static void main(String[] args) {
        //同步执行，必须等待fileReader方法执行完毕，才能进行其他操作
        FileReaderUtil.read(Constants.FILE_PATH);

        log.debug("do other things .....");
    }


}
