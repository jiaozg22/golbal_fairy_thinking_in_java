package com.jzg.thinkingInJava.test.ThreadDemo;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author jiao_zg22
 * @version 1.0
 * @description 线程数据通信，可以通过管道的方式传递
 * @date 2020/12/22 19:06
 */
public class PipDemo {
    public static void main(String[] args) throws Exception{
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();

        try {
            pipedWriter.connect(pipedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread printThread = new Thread(new Print(pipedReader),"打印线程");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read())!=-1){
                pipedWriter.write(receive);
            }
        }catch (Exception e){
        }
        finally {
            pipedWriter.close();
        }


    }
    static class Print implements Runnable {
        private PipedReader pipedReader ;

        public Print(PipedReader pipedReader){
            this.pipedReader = pipedReader;
        }
        @Override
        public void run() {

            int receive = 0 ;
            try {
                while((receive = pipedReader.read()) != -1){
                    System.out.print((char)receive);
                }
            }catch (Exception e){

            }finally {
                try {
                    pipedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
