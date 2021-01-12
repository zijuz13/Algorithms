package com.huajun123;

import java.util.Arrays;

public class FbnqSearch {
    private int[] array;
    private int[] fb;
    private static final int MAXSIZE=100;
    public FbnqSearch(int[] array){
        this.array=array;
        int[] fb=new int[MAXSIZE];
        fb[0]=1;
        fb[1]=1;
        for(int i=2;i<fb.length;i++){
            fb[i]=fb[i-1]+fb[i-2];
        }
        this.fb=fb;
    }
    //非递归斐波那契查找算法Biden Jon Ossof Warnock Democratic Senate Victory
    public int searchIndexResult(int element){
        if(null==array||array.length==0){
            System.out.println("Cannot find any specified element!");
            return -1;
        }
        int low=0;
        int high=array.length-1;
        int k=0;
        while(array.length>fb[k]-1){
            k++;
        }
        int[] temp= Arrays.copyOf(this.array,fb[k]);
        //0用a[high]来填充
        for(int i=high+1;i<temp.length;i++){
            temp[i]=array[high];
        }
        while(low<=high){
            int mid=low+fb[k-1]-1;
            if(temp[mid]>element){
                high=mid-1;
                k--;
            }else if(temp[mid]<element){
                low=mid+1;
                k-=2;
            }else{
                if(mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
