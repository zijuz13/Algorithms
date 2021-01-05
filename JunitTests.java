package com.huajun123;

import org.junit.Assert;
import org.junit.Test;

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
}
