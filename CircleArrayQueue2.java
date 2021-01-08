package com.huajun123;

public class CircleArrayQueue1 {
    private int maxSize;
    private int front;
    private int end;
    private int[] array;
    public CircleArrayQueue1(int size){
        this.front=this.end=0;
        this.maxSize=size+1;
        array=new int[size+1];
    }
    private void check(){
        if(null==array||array.length==0){
            throw new RuntimeException("必须有array用来存储");
        }
    }
    private boolean ifFull(){
        boolean flag= ((end+1)%maxSize)==front;
        if(flag){
            System.out.println("队列已满不能再添加元素"
            );
        }
        return flag;
    }
    private boolean ifEmpty(){
        boolean flag=front==end;
        if(flag){
            System.out.println("队列为空不能再获取"
            );
        }
        return flag;
    }
    public void put(int element){
        if(!ifFull()){
            array[end]=element;
            end=(end+1)%maxSize;
        }
    }
    public int get(){
        check();
        if(!ifEmpty()){
            int temp= array[front];
            front=(front+1)%maxSize;
            return temp;
        }
        return 0;
    }
    public int size(){
        return (end+maxSize-front)%maxSize;
    }
    public void brower(){
        for(int i=front;i<front+size();i++){
            System.out.println(array[i%maxSize]);
        }
    }
}
