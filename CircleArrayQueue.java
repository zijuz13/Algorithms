package com.huajun123;

//循环数组队列的实现
public class CircleArrayQueue {
    private int maxSize;
    private int front=0;
    private int rear=0;
    private int[] array;
    public CircleArrayQueue(int maxSize){
        this.maxSize=maxSize;
        array=new int[maxSize];
    }
    //是否为空
    private boolean ifEmpty(){
        return front==rear;
    }
    //获得队列大小
    private int size(){
        return (rear+maxSize-front)%maxSize;
    }
    private boolean ifFull(){
        return (rear+1)%maxSize==front;
    }
    public int get(){
        if(ifEmpty()){
            throw new RuntimeException("The queue is empty, please add elements first!");
        }else{
            int temp= array[front];
            front=(front+1)%maxSize;
            return temp;
        }
    }
    public void push(int num){
        if(ifFull()){
            throw new RuntimeException("The queue is full, and you have to pop elements first!");
        }else{
            array[rear]=num;
            rear=(rear+1)%maxSize;
        }
    }
    public void showAllElements(){
        for(int i=front;i<front+size();i++){
            System.out.print(array[i%maxSize]+" ");
        }
    }
}
