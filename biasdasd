package com.huajun123.algorithms;

import java.util.ArrayList;
import java.util.List;

//二分递归搜索
public class BinarySearch {
    private int[] array;
    private static final List<Integer> EMPTY_LIST=new ArrayList<>();
    public BinarySearch(int[] array){
        EMPTY_LIST.add(-1);
        this.array=array;
    }
    public int search(int element,int left,int right){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if(array[mid]==element){
            return mid;
        }else if(array[mid]>element){
            return this.search(element,left,mid-1);
        }else{
            return this.search(element,mid+1,right);
        }
    }
    //Improved Binary Searching which can search the same number in an array
    public List<Integer> searchList(int element,int left,int right){
        if(left>right){
            return EMPTY_LIST;
        }
        int mid=(left+right)/2;
        if(array[mid]==element){
            List<Integer> list=new ArrayList<>();
            list.add(mid);
            int temp1=mid+1;
            int temp2=mid-1;
            while(0<=temp2&&array[temp2]==element){
                list.add(temp2);
                temp2--;
            }
            while(temp1<array.length&&array[temp1]==element){
                list.add(temp1);
                temp1++;
            }
            return list;
        }else if(array[mid]>element){
            return this.searchList(element,left,mid-1);
        }else{
            return this.searchList(element,mid+1,right);
        }
    }
}
