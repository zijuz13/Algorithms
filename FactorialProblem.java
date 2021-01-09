package com.huajun123.algorithms;
//
public class FactorialProblem {
    public int factorial(int n){
        if(1==n){
            return 1;
        }
        return this.factorial(n-1)*n;
    }
}
