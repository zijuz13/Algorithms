package com.huajun123;

import java.util.Arrays;

public class MergeSort {
    private int[] originalArr;
    private int[] arr;
    public MergeSort(int[] arr){
        this.originalArr=arr;
        this.arr=arr;
    }
    public void mergeSort(){
        //只用一个temp数组来合并元素，减小空间复杂度
        int[] temp=new int[arr.length];
        this.mergeSort(0,arr.length-1,temp);
    }
    //Divide-And-Conquer分治法的应用
    private void mergeSort(int left,int right,int[] temp){
//        if(left>right)throw new RuntimeException("cannot perform merge sort because you have entered the incorrect left and right values");
        if(left==right){
            return;
        }
        //得到中间值
        int mid=(left+right)>>1;
       //分治，左边已经排好了
        this.mergeSort(left,mid,temp);
       this.mergeSort(mid+1,right,temp);
       this.merge(left,right,mid,temp);
    }
    //合并归并排序的元素
    private void merge(int left,int right,int mid,int[] temp){
     int l=left;
     int r=mid+1;
     int index=0;
     while(l<=mid&&r<=right){
         if(arr[l]>=arr[r]){
             temp[index++]=arr[r++];
         }else{
             temp[index++]=arr[l++];
         }
     }
     while(l<=mid){
      temp[index++]=arr[l++];
     }
     while(r<=right){
      temp[index++]=arr[r++];
     }
     for(int i=0;i<index;){
         arr[left++]=temp[i++];
     }
    }
    public void print(){
//        System.out.println("排序前的顺序是:"+ Arrays.toString(this.originalArr));
        System.out.println("排序后的顺序是:"+Arrays.toString(this.arr));
    }
}
