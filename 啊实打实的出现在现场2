package com.huajun123;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class HuffmanTree1 {
    private Map<Byte,String> huffmanCodes=new HashMap<>();
    private String originalStr;
    private byte[] zippedBytes;
    public static class Node implements Comparable<Node>{
        private Byte data;
        private int weight;
        private Node left;
        private Node right;
        public Node(Byte data,int weight){
            this.data=data;
            this.weight=weight;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    public String unzipString() throws UnsupportedEncodingException {
        byte[] tool = this.tool();
      //  return new String(tool,"UTF-8");
        return "fucker1!";
    }
     private byte[] tool(){
        StringBuilder builder=new StringBuilder();
         for (int i=0;i<zippedBytes.length;i++) {
           boolean flag=(i== zippedBytes.length-1);
           builder.append(this.convertBinaryToString(!flag,zippedBytes[i]));
         }
         System.out.println(builder.toString()+"length:"+builder.toString().length());
         String s = builder.toString();
         Map<String,Byte> map1=new HashMap<>();
         for (Map.Entry<Byte, String> byteStringEntry : huffmanCodes.entrySet()) {
             map1.put(byteStringEntry.getValue(),byteStringEntry.getKey());
         }
         List<Byte> list=new ArrayList<>();
         for(int i=0;i<s.length();){
          int count=1;
          while(null==map1.get(s.substring(i,i+count))){
              count++;
          }
          list.add(map1.get(s.substring(i,i+count)));
          i+=count;
         }
         byte[] bytes12=new byte[list.size()];
         for(int i=0;i<list.size();i++){
             bytes12[i]=list.get(i);
         }
         return bytes12;
     }
     private String convertBinaryToString(boolean flag,byte zippedbyte){
        int temp=zippedbyte;
        if(flag){
            temp|=256;
        }
         String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8);
        }else{
            return str;
        }
     }
    private Node root;
    public byte[] zipString(String str){
        this.originalStr=str;
        return this.constructHuffmanTree(str);
     }
    private byte[] constructHuffmanTree(String str){
        byte[] bytes = str.getBytes();
        Map<Byte,Integer> map=new HashMap<>();
        for (byte aByte : bytes) {
            Integer integer = map.get(aByte);
            if(null==integer){
                map.put(aByte,1);
            }else{
                map.put(aByte,integer+1);
            }
        }
        List<Node> list=new ArrayList<>();
        for (Map.Entry<Byte, Integer> byteIntegerEntry : map.entrySet()) {
            list.add(new Node(byteIntegerEntry.getKey(), byteIntegerEntry.getValue()));
        }
         root=this.constructHuffmanTree(list);
        // this.preOrder(root);
         this.generateHuffmanCodes();
        byte[] bytes1 = this.convertToBytesAccordingToHuffmanCodes(str);
       return zippedBytes=bytes1;
    }
    //递归创建哈夫曼树
    private Node constructHuffmanTree(List<Node> list){
        if(list.size()==0){
            return null;
        }
        if(1==list.size()){
            return list.get(0);
        }
        Collections.sort(list);
        Node node = list.get(0);
        Node node1 = list.get(1);
        list.remove(node);
        list.remove(node1);
        Node parent=new Node(null,node.weight+node1.weight);
        parent.left=node;
        parent.right=node1;
        list.add(parent);
        return this.constructHuffmanTree(list);
    }
    private void preOrder(Node node){
        System.out.println(node);
        if(null!=node.left){
           this.preOrder(node.left);
        }
        if(null!=node.right){
            this.preOrder(node.right);
        }
    }
    private void generateHuffmanCodes(){
        this.generateHuffmanCodes(root.left,"0",new StringBuilder());
        this.generateHuffmanCodes(root.right,"1",new StringBuilder());
    }
    //递归创建哈夫曼编码
    private void generateHuffmanCodes(Node node,String code,StringBuilder builder1){
        StringBuilder builder = new StringBuilder(builder1);
        builder.append(code);
        if(null!=node.data){
            huffmanCodes.put(node.data,builder.toString());
        }else{
                this.generateHuffmanCodes(node.left,"0",builder);
                this.generateHuffmanCodes(node.right,"1",builder);
        }
    }
    private byte[] convertToBytesAccordingToHuffmanCodes(String str){
        StringBuilder builder=new StringBuilder();
        for (byte aByte : str.getBytes()) {
            builder.append(huffmanCodes.get(aByte));
        }
        String s = builder.toString();
        int len;
        if(s.length()%8==0){
            len=s.length()/8;
        }else{
            len=s.length()/8+1;
        }
        byte[] bytes=new byte[len];
        int count=0;
        for(int i=0;i<s.length();i+=8){
            String convertingString=null;
         if((i+8)>s.length()){
             convertingString=s.substring(i);
         }else{
             convertingString=s.substring(i,i+8);
         }
         bytes[count++]=(byte)Integer.parseInt(convertingString,2);
        }
        return bytes;
    }
}
