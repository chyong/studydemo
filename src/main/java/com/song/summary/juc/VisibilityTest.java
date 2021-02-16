package com.song.summary.juc;

/**
 * Java内存模型内存交互举例代码
 */
public class VisibilityTest {
    private boolean flag = true;

    public void refresh() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag");
    }

    public void load() {
        System.out.println(Thread.currentThread().getName() + "开始执行...");
        int i = 0;
        while (flag) {
            i++;
            doSomething(0);
        }
        System.out.println(Thread.currentThread().getName() + "跳出循环：i=" + i);
    }

    public void doSomething(int x) {
        switch (x) {
            case 1: // 能跳出循环
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2: // 能跳出循环
                System.out.println("====="); // synchronized
                break;
            case 3: // 不能跳出循环
                shortWait(10000); // 10微秒
                break;
            case 4: // 能跳出循环
                shortWait(20000); // 20微秒
                break;
            case 0: // 不能跳出循环
            default: // 不能跳出循环
                // do nothing
                break;
        }
    }

    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }

    public static void main(String[] args) {
        /*
        下面的代码，修改load函数中doSomething(0);传入的值，从0到4，分别会出现能跳出循环和不能跳出循环两种情况
        0，什么也不做，不能跳出循环
        1，sleep，能跳出循环
        2，使用System.out.println输出，能跳出循环
        3，等待10微秒，不能跳出循环
        4，等待20微秒，能跳出循环
         */
        VisibilityTest test = new VisibilityTest();
        new Thread(test::load, "threadA").start();
        try {
            Thread.sleep(2000);
            new Thread(test::refresh, "threadB").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
