package com.huajun123;

import java.util.Stack;

//Data Structure and Algorithms Analysis
public class SingleDirectionalLinkedList {
    static class Node{
         private int id;
         private String name;
         private String price;
         private Node next;
         //初始化头结点的构造方法
         public Node(int id){
             this.id=id;
         }
         public Node(int id,String name,String price){
             this.id=id;
             this.name=name;
             this.price=price;
         }
        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price='" + price ;
        }
    }
    private Node head;
    public SingleDirectionalLinkedList(){
        head=new Node(0);
    }
    //获得反转后的链表
    public SingleDirectionalLinkedList(SingleDirectionalLinkedList originalLinkedList){
        Node head= originalLinkedList.head;
        this.head=new Node(0);
        if(head.next==null||head.next.next==null){
          this.head.next=head.next;
          return;
        }
        Node cur=head.next;
        Node temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=this.head.next;
            this.head.next=cur;
            cur=temp;
        }
    }
    //获得反转后的链表
    public SingleDirectionalLinkedList getReversedSingleDirectionalLinkedList(){
        return new SingleDirectionalLinkedList(this);
    }
    public void printNodesByReversedOrder(){
        Stack<Node> stack=new Stack<>();
        Node temp=head.next;
        if(null==temp){
            System.out.println("no nodes can be printed");
            return;
        }
        while(null!=temp){
            stack.push(temp);
            temp=temp.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
    //给队列的最尾部添加元素
    public void push(Node node){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }
    //按照顺序添加元素
    public void pushByOrder(Node node){
       Node temp=head;
       while(true){
       if(null==temp.next){
           break;
       }else if(node.id<temp.next.id){
           break;
       }else{
           temp=temp.next;
       }
       }
       Node temp1=temp.next;
       temp.next=node;
       node.next=temp1;
    }
    public Node delById(int id){
     Node temp=head.next;
     boolean flag=false;
     while(true){
         if(null==temp){
             throw new RuntimeException("链表的长度为空");
         }
         if(null==temp.next){
            break;
         }
         if(temp.next.id==id){
             flag=true;
             break;
         }
         temp=temp.next;
     }
     if(flag){
         Node returnedNode=temp.next;
         System.out.println("删除的节点信息是:"+returnedNode);
         temp.next=temp.next.next;
         return returnedNode;
     }else{
         throw new RuntimeException("无法找到需要删除的节点");
     }
    }
    public void updateNode(Node node){
        Node temp=head;
        boolean flag=false;
        while(temp.next!=null){
            if(temp.next.id==node.id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            Node fuck=temp.next;
            temp.next=node;
            node.next=fuck;
        }else{
            System.out.println("无法更新，原因是根据id找不到要更新的节点");
        }
    }
    //遍历显示链表中存储的节点
    public void list(){
        Node temp=head.next;
        if(null==temp){
            System.out.println("没有节点可以显示");
        }else{
            while(null!=temp){
                System.out.println(temp);
                temp=temp.next;
            }
        }
    }
}
