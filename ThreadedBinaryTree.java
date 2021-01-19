package com.huajun123;
//线索化二叉树
public class ThreadedBinaryTree {
    private Node root;
    //Assist in forming threaded nodes
    private Node pre;
    public static class Node{
        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getRightType() {
            return rightType;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        private Long id;
        private Node left;
        //用来标识是否是前驱节点0还是左子树1
        private int leftType;
        //用来标识是否是后继节点0或者右子树1
        private int rightType;
        private Node right;
        public Node(Long id){
            this.id=id;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +"}";
        }
    }
    //初始化根节点,即整颗树
    public ThreadedBinaryTree(Node initialRoot){
        this.root=initialRoot;
        this.pre=null;
    }
    //暴露公共的中序遍历方法
    public void infixOrder(){
        this.infixOrder(this.root);
    }
    //中序遍历
    private void infixOrder(Node node){
        if(null==node){
            throw new RuntimeException("Root value cannot be null");
        }
        if(null!=node.left){
            this.infixOrder(node.left);
        }
        System.out.println(node);
        if(null!=node.right){
            this.infixOrder(node.right);
        }
    }
    public void threadNodes(){
        this.threadingNodes(this.root);
    }
    //线索化二叉树方法
    private void threadingNodes(Node node){
        if(null!=node.left){
            this.threadingNodes(node.left);
        }else{
            node.leftType=1;
            node.left=pre;
        }
        if(null!=pre&&null==pre.right){
            pre.rightType=1;
            pre.right=node;
        }
        pre=node;
        if(null!=node.right){
            this.threadingNodes(node.right);
        }
    }
}
