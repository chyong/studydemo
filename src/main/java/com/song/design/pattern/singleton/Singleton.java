package com.song.design.pattern.singleton;

public class Singleton {
    private static Singleton instance;
    private volatile static Singleton singleton;
    private Singleton (){}

    //懒汉式，线程不安全
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //懒汉式，线程安全
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    //双检锁/双重校验锁（DCL，即 double-checked locking）
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

}
