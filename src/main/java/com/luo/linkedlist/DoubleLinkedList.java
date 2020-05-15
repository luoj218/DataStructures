package com.luo.linkedlist;

import javafx.beans.binding.When;

/**
 * @author : Administrator
 * @date : 2020/5/15
 * @description : 双向链表
 */
public class DoubleLinkedList implements LinkedList<DoubleNode> {

    private DoubleNode head = new DoubleNode(0, 0);

    /**
     * 长度
     */
    private int size;

    /**
     * 获取头结点
     *
     * @return 头结点
     */
    @Override
    public DoubleNode getHead() {
        return head;
    }

    /**
     * 添加结点 (尾部添加)
     *
     * @param node 结点
     */
    @Override
    public void add(DoubleNode node) {
        DoubleNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
        size++;
    }

    /**
     * 顺序添加
     *
     * @param node 结点
     */
    @Override
    public void addByOrder(DoubleNode node) {
        DoubleNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            // temp node temp.next
            if (temp.next.no > node.no) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            // 后移
            temp = temp.next;
        }
        if (flag) {
            throw new RuntimeException(String.format("DoubleNode(%d) exists", node.no));
        } else {
            if (temp.next != null) {
                temp.next.pre = node;
            }
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
            size++;
        }
    }

    @Override
    public void update(DoubleNode node) {

    }

    @Override
    public void delete(int no) {

    }

    /**
     * 返回所有结点
     *
     * @return 结点的数组
     */
    @Override
    public DoubleNode[] nodes() {
        DoubleNode[] nodes = new DoubleNode[size];
        DoubleNode temp = head.next;
        int index = 0;
        while (temp != null) {
            nodes[index++] = temp;
            temp = temp.next;
        }

        return nodes;
    }

    @Override
    public int size() {
        return 0;
    }

}

class DoubleNode {

    int no;

    int val;

    DoubleNode next;

    DoubleNode pre;

    DoubleNode(int no, int val) {
        this.no = no;
        this.val = val;
    }

    @Override
    public String toString() {
        return "DoubleNode{" + "no=" + no + ", val=" + val + '}';
    }

}