package com.jzg.thinkingInJava.test.DelayInitiialization;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 基于类初始化的解决方案：在执行类的初始化期间，JVM会获取一个锁，这个锁可以同步多个线程对同一个类的初始化
 * 保证类变量的延迟初始化是线程安全的。不能保证实例变量的安全性
 * @date 2020/12/17 14:21
 */
public class InstanceFactory {
    private static class InstanceHolder{
        public static Instance instance = new Instance();
    }
    public static Instance getInstance(){
        return InstanceHolder.instance;
    }
}
