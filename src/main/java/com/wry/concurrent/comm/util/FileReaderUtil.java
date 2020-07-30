package com.wry.concurrent.comm.util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * <p>
 *
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/26
 */
@Slf4j
public class FileReaderUtil {
    
    public static void read(String path) {
        log.debug("FileReader start .....");
        try {
            FileReader reader = new java.io.FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        log.debug("FileReader end .....");
    }
}
