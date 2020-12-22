package com.jzg.thinkingInJava.test.DelayInitiialization;


/**
 * @author jiao_zg22
 * @version 1.0
 * @description 基于双重检查锁定来实现延迟初始化的方案：volitile
 * 对实例变量和静态变量都可以保证延迟初始化的安全性
 * @date 2020/12/17 14:17
 */
public class SafeDoubleCheckLocking {
    private volatile Object object;

    private volatile static Instance instance ;
    public static Instance getInstance(){
        if(instance == null){
            synchronized (SafeDoubleCheckLocking.class){
                if(instance == null){
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
