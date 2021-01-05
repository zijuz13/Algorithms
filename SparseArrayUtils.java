package com.huajun123;

public class SparseArrayUtils {
    public int[][] convertToStoreArray(int[][] array){
        int nonZeroNumber = this.getNonZeroNumber(array);
        int[][] sparseArray=new int[nonZeroNumber+1][3];
        sparseArray[0][0]= array.length;
        sparseArray[0][1]= array[0].length;
        sparseArray[0][2]=nonZeroNumber;
        int count=0;
        for(int i=0;i< array.length;i++){
            for(int j=0;j< array[i].length;j++){
                if(0!=array[i][j]){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=array[i][j];
                }
            }
            }
        return sparseArray;
    }
    public int[][] recoverToSparseArray(int[][] array){
        int rows=array[0][0];
        int columns=array[0][1];
        int[][] originalArray=new int[rows][columns];
        for(int i=1;i< array.length;i++){
            int index1=array[i][0];
            int index2=array[i][1];
            originalArray[index1][index2]=array[i][2];
        }
        return originalArray;
    }
    private int getNonZeroNumber(int[][] array){
        int count=0;
        for(int i=0;i< array.length;i++){
            for(int j=0;j< array[i].length;j++){
                if(0!=array[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private void printTwoDimensionalArrayToConsole(int[][] array){
        for(int i=0;i< array.length;i++){
        for(int j=0;j< array[i].length;j++){
            System.out.print(array[i][j]+" "+((j== array[i].length-1)?"\n":""));
        }
    }
    }
    public void executeTheWholeProcess(int[][] array){
        this.printTwoDimensionalArrayToConsole(array);
        int[][] newArray=null;
     this.printTwoDimensionalArrayToConsole(newArray=this.convertToStoreArray(array));
     this.printTwoDimensionalArrayToConsole(this.recoverToSparseArray(newArray));
    }
}
