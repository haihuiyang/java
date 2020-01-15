package com.yhh.example;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author HappyFeet
 * @since Jan 07, 2020
 */

public class LinkList {

    private Node head;
    private Node tail;

    public static void main(String[] args) {

        ArrayList<Integer> integers = Lists.newArrayList(1, 3, 9, 7, 5, 2);

        LinkList linkList = new LinkList();

        integers.forEach(index -> {

            linkList.enq(new Node(index));

        });

        System.out.println(linkList.head);

    }

    public Node enq(Node node) {
        for (; ; ) {
            if (head == null) {
                head = tail = new Node(0);
            } else {
//                Node t = tail;
//                node.pre = t;
//                tail = node;
//                t.next = node;
//                return t;

                Node t = tail;
                t.next = node;
                tail = node;
                node.pre = t;
                return node;
            }
        }
    }

    static final class Node {

        private Node pre;
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append("Node{")
                    .append("pre=")
                    .append(pre == null ? "null" : pre.getValue())
                    .append(", value=")
                    .append(value)
                    .append(", next=")
                    .append(next == null ? "null" : next.getValue())
                    .append('}').toString();
        }
    }

}
