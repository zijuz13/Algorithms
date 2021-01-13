package com.huajun123;

public class BinaryTree {
    private Node root;
    public BinaryTree(){
       Node node1=new Node(1L,"huajun");
       Node node2=new Node(2L,"huajun2");
       Node node3=new Node(3L,"huajun3");
       Node node4=new Node(4L,"dasdasdas");
       Node node5=new Node(5L,"asdaswqerwqe");
       root=node1;
       node1.setLeft(node2);
       node1.setRight(node3);
       node2.setLeft(node4);
       node2.setRight(node5);
    }
    public void deleteById(Long id){
        this.infix();
        if(root.id==id){
            root=null;
            System.out.println("成功删除根节点");
        }else {
            int i = this.deleteById(root, id);
            if (1 == i) {
                System.out.println("成功删除数据");
            } else {
                System.out.println("the specified element did not exist!");
            }
        }
    }
    private int deleteById(Node node,Long id){
        if(null==node){
            throw new RuntimeException("根节点根本不能为null知道吗");
        }
        if(null!=node.left&&node.left.id==id){
                node.left=null;
                return 1;
        }
        if(null!=node.right&&node.right.id==id){
                node.right=null;
                return 1;
        }
        if(null!=node.left&&1==this.deleteById(node.left,id)){
            return 1;
        }
        if(null!=node.right&&1==this.deleteById(node.right,id)){
            return 1;
        }
        return -1;
    }
    public Node infixSearch(Long id){
        return this.infixSearchById(this.root,id);
    }
    //根据id来进行中序搜索
    private Node infixSearchById(Node node,Long id){
        if(null==node){
            throw new RuntimeException("不能进行中序查找，因为根节点为null");
        }
        Node resNode=null;
        if(null!=node.left){
            resNode=this.infixSearchById(node.left,id);
        }
        if(null!=resNode){
            return resNode;
        }
        if(node.id==id){
            return node;
        }
        if(null!=node.right){
            resNode=this.infixSearchById(node.right,id);
        }
        return resNode;
    }
    public void infix(){
        this.infixExplorer(root);
    }
    public void prefix(){
        this.prefixExplorer(root);
    }
    public void postfix(){
        this.postfixExplorer(root);
    }
    //中序遍历二叉树
    private void infixExplorer(Node node){
        if(null!=node.left){
            this.infixExplorer(node.left);
        }
        System.out.println(node);
        if(null!=node.right){
            this.infixExplorer(node.right);
        }
    }
    //前序遍历二叉树
    private void prefixExplorer(Node node){
        System.out.println(node);
        if(null!=node.left){
            this.prefixExplorer(node.left);
        }
        if(null!=node.right){
            this.prefixExplorer(node.right);
        }
    }
    //后序遍历二叉树
    private void postfixExplorer(Node node){
       if(null!=node.left){
           this.postfixExplorer(node.left);
       }
       if(null!=node.right){
           this.postfixExplorer(node.right);
       }
        System.out.println(node);
    }
    static class Node{
        private Long id;
        private String name;
        private Node left;
        private Node right;
        public Node(Long id,String name){
            this.id=id;
            this.name=name;
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

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
