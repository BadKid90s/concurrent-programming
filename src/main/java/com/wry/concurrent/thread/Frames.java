package com.wry.concurrent.thread;

/**
 * <p>
 * 方法调用查看方法栈和栈帧
 * </p>
 *
 * @author wangruiyu
 * @since 2020/7/27
 */
public class Frames {
    public static void main(String[] args) {
        method1(10);
    }

    private static void method1(int x) {
        int y = x + 1;
        Object o = method2();
        System.out.println(o);
    }

    private static Object method2() {
        Object o = new Object();
        return o;
    }
}
