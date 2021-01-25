package com.huajun123.algorithms;

import java.util.*;

public class HuffmanTree {
    private Map<Byte,String> huffmanCodes=new HashMap<>();
    //存放转换后的huffmantree
    private Node root;
    public void analyzeCodeFromString(String str){
     this.zipString(str);
    }
    //压缩str
    public byte[] zipString(String str){
        List<Node> nodes = this.formNodesFromString(str);
        Node node = this.convertToHuffmanTree(nodes);
        this.preOrder(node);
        this.getHuffmanTree();
        byte[] bytes = str.getBytes();
//        int len=0;
//        if(0==bytes.length%8){
//            len=bytes.length/8;
//        }else{
//            len=bytes.length/8+1;
//        }
        StringBuilder builder=new StringBuilder();
        for (byte aByte : bytes) {
            String s = huffmanCodes.get(aByte);
            builder.append(s);
        }
//        System.out.println("压缩后形成的二进制串是："+builder.toString()+", 长度是："+builder.length());
      int len=0;
         if(0==builder.length()%8){
            len=builder.length()/8;
        }else{
            len=builder.length()/8+1;
        }
        byte[] bytes1 = new byte[len];
         int count=0;
         for(int i=0;i<builder.length();i+=8){
             String substring=null;
             if(builder.length()<(i+8)){
              substring = builder.substring(i);
             }else
             substring = builder.substring(i, i + 8);
             bytes1[count]=(byte) Integer.parseInt(substring,2);
             count++;
         }
        System.out.println(Arrays.toString(bytes1));
        return bytes1;
    }
    public static class Node implements Comparable<Node>{
        private Byte data;
        private int weight;
        private Node left;
        private Node right;
        public Byte getData() {
            return data;
        }

        public void setData(Byte data) {
            this.data = data;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }
    //将str转成nodes
    private List<Node> formNodesFromString(String str){
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
        System.out.println(map);
        List<Node> nodes=new ArrayList<>();
        for (Map.Entry<Byte, Integer> byteIntegerEntry : map.entrySet()) {
            nodes.add(new Node(byteIntegerEntry.getKey(),byteIntegerEntry.getValue()));
        }
        return nodes;
    }
    //产生哈夫曼编码
    private void initializeHuffmanCodes(Node node,String str,StringBuilder stringBuilder){
        StringBuilder builder=new StringBuilder(stringBuilder);
        builder.append(str);
        if(null!=node.data){
            huffmanCodes.put(node.data,builder.toString());
        }else{
            if(null!=node.left)
            this.initializeHuffmanCodes(node.left,"0",builder);
            if(null!=node.right)
                this.initializeHuffmanCodes(node.right,"1",builder);
        }
    }
    private void getHuffmanTree(){
        if(null==root){
            throw new RuntimeException("无法得到HuffmanCodes,因为root为null");
        }else{
            this.initializeHuffmanCodes(root.left,"0",new StringBuilder());
            this.initializeHuffmanCodes(root.right,"1",new StringBuilder());
        }
    }
    private Node convertToHuffmanTree(List<Node> nodes){
        while(1<nodes.size()){
            Collections.sort(nodes);
            Node node = nodes.get(0);
            Node node1 = nodes.get(1);
            Node parent=new Node(null,node.weight+node1.weight);
            parent.left=node;
            parent.right=node1;
            nodes.remove(node);
            nodes.remove(node1);
            nodes.add(parent);
        }
        root=nodes.get(0);
        return root;
    }
    //前序遍历新的哈夫曼树
    private void preOrder(Node node){
        System.out.println(node);
        if(null!=node.left){
            preOrder(node.left);
        }
        if(null!=node.right){
            preOrder(node.right);
        }
    }
}
