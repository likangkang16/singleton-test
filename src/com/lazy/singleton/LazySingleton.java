package com.lazy.singleton;

/**
 * @ClassName LazySingleton
 * @Description //TODO 懒汉式单例
 * @Author lkk
 * Date 2022/05/30/16:51
 * @Version 1.0
 **/
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton lazySingleton = null;

    //静态工厂方法-懒汉式单例
    //懒汉式单例模式。在高并发的时候，会导致多个线程出现，导致线程不安全，需要进行修改
    //1.加锁
    public synchronized static LazySingleton getInstance1() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


    //2.双重锁检查 volatile 指定禁止重新定序
    private static volatile LazySingleton lazySingletons = null;

    //双重if判断原因是：当第一个线程抢到锁后，会直接new一个对象，释放锁后，第二个线程，将不行在去new对象，确保只有一个线程创建对象，提高了线程安全，减少创建消耗
    public static LazySingleton getInstance2() {
        if (lazySingletons == null) {
            synchronized (LazySingleton.class) {
                if (lazySingletons == null) {
                    lazySingletons = new LazySingleton();
                }
            }
        }
        return lazySingletons;
    }


    //3.静态内部类
    //利用类在加载的时候，直接生成一个单例，既可以确定生成的实例为单例，线程安全，也可以减少创建的消耗
    public static class LazyHelp{
        private final static LazySingleton lazySingleton=new LazySingleton();
    }

    public static final LazySingleton getInstance3(){
        return  LazyHelp.lazySingleton;
    }
}
