package com.huajun123;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainClass {
//    private static AtomicBoolean lock=new AtomicBoolean(true);
    private static boolean lock=true;
    static class Thread1 extends Thread{
        @Override
        public void run() {
            if(lock){
            lock=false;
            System.out.println("I have been executed");
            }else{
            System.out.println("I did not get a lock to execute the code in the critical section");
        }
        }
    }
    static class Fucker{
        private boolean lock=true;
        public void getLock(){
            if(lock){
                lock=false;
                System.out.println("I have been executed");
            }else{
                System.out.println("I did not get a lock to execute the code in the critical section");
            }
        }
    }
    static class Fucker1{
        private boolean lock3=true;
        public void run() throws InterruptedException {
         if(lock3){
             lock3=false;
             System.out.println("获得锁");
             Thread.sleep(3000);
         }else{
             System.out.println("没有获得锁");
         }
        }
    }
    //当循环时根本无法进入下面setLock代码执行
    public static void main(String[] args) {
//      Thread[] array=new Thread[10000];
//      for(int i=0;i<=9999;i++){
//          array[i]=new Thread1();
//      }
//      for (int i=0;i<=9999;i++){
//          array[i].start();
//      }
//        int[][] array=new int[10][10];
//        array[8][3]=38;
//        array[3][8]=83;
//        array[1][8]=38;
//        new SparseArrayUtils().executeTheWholeProcess(array);
    }
    public static void casTest(){

    }

}
