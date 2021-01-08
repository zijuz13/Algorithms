package com.huajun123;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversalPolandComputer {
    private static final String ADD="+";
    private static final String MINUS="-";
    private static final String MULTIPLY="*";
    private static final String DIVIDE="/";
    public int suffixCompute(List<String> expressions){
        //To store numbers
        Stack<Integer> stack1=new Stack<>();
     for(int i=0;i<expressions.size();i++){
         String str=expressions.get(i);
         if(!ifOperator(str)){
            stack1.push(Integer.parseInt(str));
         }else{
             int num2=stack1.pop();
             int num1=stack1.pop();
             stack1.push(this.computeTemporaryResults(str,num1,num2));
         }
         }
     return stack1.peek();
    }
    private boolean ifOperator(String character){
        return Arrays.asList(ADD,MINUS,MULTIPLY,DIVIDE).contains(character);
    }
    private int computeTemporaryResults(String operator,int num1,int num2){
        switch (operator){
            case ADD:{
                return num1+num2;
            }
            case MINUS:{
                return num1-num2;
            }
            case MULTIPLY:{
                return num1*num2;
            }
            case DIVIDE:{
                return num1/num2;
            }
            default:{
                throw new RuntimeException("Cannot discern what the operator is, please correctly specify it");
            }
        }
    }
}
