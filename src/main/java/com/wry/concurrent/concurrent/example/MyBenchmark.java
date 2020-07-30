package com.wry.concurrent.concurrent.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <p>
 * 用同步和异步两中方式计算数据所消耗的时间
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/26
 */
@Slf4j
public class MyBenchmark {

    static int[] ARRAY = new int[4000_000_00];

    static {
        Arrays.fill(ARRAY, 1);
    }

    /**
     * 异步计算 ，创建4个线程去同步计算结果，最后合并计算结果
     */
    public static void async() throws ExecutionException, InterruptedException {
        //开始时间
        Long start = System.currentTimeMillis();
        int[] array = ARRAY;
        FutureTask<Integer> task1 = new FutureTask<Integer>(() -> {
            int sum = 0;
            for (int i = 0; i < 1000_000_00; i++) {
                sum += array[0 + i];
            }
            return sum;
        });
        FutureTask<Integer> task2 = new FutureTask<Integer>(() -> {
            int sum = 0;
            for (int i = 0; i < 1000_000_00; i++) {
                sum += array[1000_000_00 + i];
            }
            return sum;
        });
        FutureTask<Integer> task3 = new FutureTask<Integer>(() -> {
            int sum = 0;
            for (int i = 0; i < 1000_000_00; i++) {
                sum += array[2000_000_00 + i];
            }
            return sum;
        });
        FutureTask<Integer> task4 = new FutureTask<Integer>(() -> {
            int sum = 0;
            for (int i = 0; i < 1000_000_00; i++) {
                sum += array[3000_000_00 + i];
            }
            return sum;
        });

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        new Thread(task4).start();
        int i = task1.get() + task2.get() + task3.get() + task4.get();
        //结束时间
        Long end = System.currentTimeMillis();
        System.out.println("异步计算：计算结果：" + i + "\t总计耗时：" + (end - start));
    }

    /**
     * 同步计算
     */
    private static void sync() {
        //开始时间
        Long start = System.currentTimeMillis();
        int[] array = ARRAY;
        int sum = 0;
        for (int i = 0; i < 4000_000_00; i++) {
            sum += array[i];
        }
        //结束时间
        Long end = System.currentTimeMillis();
        System.out.println("同步计算：计算结果：" + sum + "\t总计耗时：" + (end - start));
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同步计算
        sync();
        //异步计算
        async();
    }

}
