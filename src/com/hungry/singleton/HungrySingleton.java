package com.hungry.singleton;

/**
 * @ClassName HungrySingleton
 * @Description //TODO 饿汉式单例
 * @Author lkk
 * Date 2022/05/30/17:24
 * @Version 1.0
 **/
public class HungrySingleton {

    private HungrySingleton() {
    }

    ;

    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    //饿汉式单例，在类生成的时候，会自动创建一个实例，所有线程是安全
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

//    饿汉式和懒汉式区别：
//     （1）初始化时机与首次调用：
//    饿汉式是在类加载时，就将单例初始化完成，保证获取实例的时候，单例是已经存在的了。所以在第一次调用时速度也会更快，因为其资源已经初始化完成。
//    懒汉式会延迟加载，只有在首次调用时才会实例化单例，如果初始化所需要的工作比较多，那么首次访问性能上会有些延迟，不过之后就和饿汉式一样了。
//    （2）线程安全方面：饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题，懒汉式本身是非线程安全的，需要通过额外的机制保证线程安全
}
