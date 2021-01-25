package com.huajun123;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
public class JunitTests {
    //测试循环队列
    @Test
    public void testCircleQueue() {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(6);
        circleArrayQueue.push(2);
        circleArrayQueue.push(3);
        circleArrayQueue.push(3);
        circleArrayQueue.push(10);
//        circleArrayQueue.push(11);
        circleArrayQueue.push(1);
        circleArrayQueue.showAllElements();
        int i = circleArrayQueue.get();
        int i1 = circleArrayQueue.get();
        int i2 = circleArrayQueue.get();
        System.out.println(i + "" + i1 + "" + i2);
        circleArrayQueue.push(2);
        circleArrayQueue.push(8);
        circleArrayQueue.push(13);
        circleArrayQueue.showAllElements();
    }
    public SingleDirectionalLinkedList pushLinkedListUsingTestData(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = new SingleDirectionalLinkedList();
        for(int i=0;i<10;i++) {
            singleDirectionalLinkedList.push(new SingleDirectionalLinkedList.Node(i,"hujkc12"+i,i+"10000"+i));
        }
        singleDirectionalLinkedList.list();
        return singleDirectionalLinkedList;
    }
    public SingleDirectionalLinkedList pushByOrderLinkedListUsingTestData(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = new SingleDirectionalLinkedList();
        for(int i=9;i>=0;i--) {
            singleDirectionalLinkedList.pushByOrder(new SingleDirectionalLinkedList.Node(i,"hujkc12"+i,i+"10000"+i));
        }
        singleDirectionalLinkedList.list();
        return singleDirectionalLinkedList;
    }
    @Test
    public void testPushLinkedList(){
     this.pushLinkedListUsingTestData();
    }
    @Test
    public void testPushByOrderLinkedList(){
        this.pushByOrderLinkedListUsingTestData();
    }
    @Test
    public void testDeleteLinkedList(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = this.pushLinkedListUsingTestData();
        singleDirectionalLinkedList.delById(1);
        singleDirectionalLinkedList.list();
    }
    @Test
    public void testDeleteEmptyLinkedList(){
        try {
            SingleDirectionalLinkedList singleDirectionalLinkedList = new SingleDirectionalLinkedList();
            singleDirectionalLinkedList.delById(1);
        }catch (Exception e){
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("链表的长度为空"));
        }
    }
    @Test
    public void testDeleteLinkedListByNonExtantId(){
        try{
        SingleDirectionalLinkedList singleDirectionalLinkedList = this.pushLinkedListUsingTestData();
        singleDirectionalLinkedList.delById(16);}
        catch (Exception e){
            Assert.assertTrue(e.getMessage().equalsIgnoreCase("无法找到需要删除的节点"));
        }
    }
    @Test
    public void updateLinkedList(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = this.pushByOrderLinkedListUsingTestData();
        singleDirectionalLinkedList.updateNode(new SingleDirectionalLinkedList.Node(8,"huanghan123","we never hide!"));
        singleDirectionalLinkedList.list();
    }
    @Test
    public void updateLinkedListByNonExtantId(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = this.pushByOrderLinkedListUsingTestData();
        singleDirectionalLinkedList.updateNode(new SingleDirectionalLinkedList.Node(60,"huanghan123","we never hide!"));
        singleDirectionalLinkedList.list();
    }
    @Test
    public void testReversingLinkedList(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = this.pushLinkedListUsingTestData();
        singleDirectionalLinkedList.getReversedSingleDirectionalLinkedList().list();
    }
    @Test
    public void testReversingLinkedList1(){
        SingleDirectionalLinkedList singleDirectionalLinkedList = this.pushLinkedListUsingTestData();
        singleDirectionalLinkedList.printNodesByReversedOrder();
    }
    @Test
    public void testBidenAddingObjects(){
        JoeBidenQueue joeBidenQueue = new JoeBidenQueue();
        joeBidenQueue.addBidens(20);
        joeBidenQueue.showAllBidensInOrder();
    }
    @Test
    public void testJoeBidenChuquanActivity(){
        JoeBidenQueue joeBidenQueue = new JoeBidenQueue();
        joeBidenQueue.addBidens(5);
        joeBidenQueue.chuquanhuodong(1,2);
    }
    @Test
    public void putTests(){
        CircleArrayQueue1 circleArrayQueue1 = new CircleArrayQueue1(6);
        for(int i=1;i<=6;i++){
            circleArrayQueue1.put(i);
        }
        for(int i=1;i<=2;i++){
            System.out.println(circleArrayQueue1.get());
        }
        System.out.println("-------------");
        circleArrayQueue1.put(60);
        circleArrayQueue1.put(100);
        circleArrayQueue1.brower();
    }
    @Test
    public void testReversalComputer(){
        ReversalPolandComputer reversalPolandComputer = new ReversalPolandComputer();
        System.out.println(reversalPolandComputer.suffixCompute(Arrays.asList("30","4","+","5","*","6","-")));
    }
    @Test
    public void testRecursivelyJoeBidenQueue(){
        RecursiveJoeQueue recursiveJoeQueue = new RecursiveJoeQueue();
        recursiveJoeQueue.addBidens(5);
        recursiveJoeQueue.chuquanhuodong(1,2);
    }
    @Test
    public void testEnumClassInPorlandExpression(){
        System.out.println(ReversalPolandComputer.Operator.DIVIDE.comp(ReversalPolandComputer.Operator.MINUS));
    }
    @Test
    public void testInfixToPostFix(){
        ReversalPolandComputer reversalPolandComputer = new ReversalPolandComputer();
        System.out.println(reversalPolandComputer.infixExpressionToPostFix("1+((2+3)*4)-5"));
    }
        @Test
    public void testThreadedBinaryTree(){
        ThreadedBinaryTree.Node node1=new ThreadedBinaryTree.Node(1L);
        ThreadedBinaryTree.Node node2=new ThreadedBinaryTree.Node(3L);
        ThreadedBinaryTree.Node node3=new ThreadedBinaryTree.Node(6L);
        ThreadedBinaryTree.Node node4=new ThreadedBinaryTree.Node(8L);
        ThreadedBinaryTree.Node node5=new ThreadedBinaryTree.Node(10L);
        ThreadedBinaryTree.Node node6=new ThreadedBinaryTree.Node(14L);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(node1);
        threadedBinaryTree.threadNodes();
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());
    }
        @Test
    public void testHeapSort(){
        new HeapSort(new int[]{32,43,1,66,95,68,74,102,0,23,-1}).sort();
    }
    @Test
    public void testHuff1(){
//        List<HuffmanTree.Node> nodes = new HuffmanTree().formNodesFromString("i like like like java do you like a java");
//        Collections.sort(nodes);
//        System.out.println(nodes);
    }
    @Test
    public void testHuff2(){
        new HuffmanTree().analyzeCodeFromString("i like like like java do you like a java");
    }
}
