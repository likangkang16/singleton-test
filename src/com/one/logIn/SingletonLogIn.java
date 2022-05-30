package com.one.logIn;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SingletonLogIn
 * @Description //TODO 单点登录
 * @Author lkk
 * Date 2022/05/30/17:29
 * @Version 1.0
 **/
public class SingletonLogIn {

    private static Map<String, SingletonLogIn> map = new HashMap<>();

    static {
        SingletonLogIn singletonLogIn = new SingletonLogIn();
        map.put(singletonLogIn.getClass().getName(), singletonLogIn);
    }

    protected SingletonLogIn() {
    }

    ;

    //登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，对于已经登记过的实例，则从Map直接返回，对于没有登记的，则先登记，然后返回
    public static SingletonLogIn getInstance(String name) {
        if (name == null) {
            name = SingletonLogIn.class.getName();
            System.out.println("name---》" + name);
        }
        if (map.get(name) == null) {
            name = SingletonLogIn.class.getName();
            try {
                map.put(name, (SingletonLogIn) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
