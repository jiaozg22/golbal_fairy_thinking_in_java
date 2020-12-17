package com.jzg.thinkingInJava.test.annotation.tests;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 接口
 * @date 2020/11/25 11:17
 */
public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<String>();
    static long testRun = 0;
    static long failures = 0;
    public static void main(String[] args){
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);//设置断言
        new ProcessFiles(new AtUnit,"class").start(args);
        if(failures == 0){
            print("OK (" + testRun + "tests");
        } else {
            print("(" + testRun + "tests");
            print("n>>>" + failures + " FAILURE" + (failures > 1 ? "S" : "") + "<<<");
            for(String failed : failedTests) {
                print(" " + failed);
            }
        }
    }

    public void process(Path file){

    }
}
