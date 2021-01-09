package com.huajun123.algorithms;
//递归解决八皇后问题
public class EightQueenProblem {
    private int[] array=new int[8];
    private int judgeCount;
    private int count;
    public EightQueenProblem workOutThisProblem(){
        this.findResultsRecursively(0);
        System.out.println(count);
        return this;
    }
    public void getJudgeCount(){
        System.out.println(judgeCount);
    }
    //判断这个皇后和之前已经摆好的皇后是否存在冲突
    private boolean judge(int n){
        judgeCount++;
        for(int i=0;i<n;i++){
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
            return false;
          }
        }
        return true;
    }
    private void findAnAnswer(){
        count++;
        for(int a:array){
            System.out.print(a);
        }
        System.out.println("");
    }
    //递归算法
    private void findResultsRecursively(int n){
        if(8==n){
            this.findAnAnswer();
            return;
        }
        for(int i=0;i<8;i++){
         array[n]=i;
         if(judge(n)){
             this.findResultsRecursively(n+1);
         }
        }
    }
}
