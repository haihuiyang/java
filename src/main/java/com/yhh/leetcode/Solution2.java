package com.yhh.leetcode;

public class Solution2 {


    /**
     * https://leetcode.com/problems/add-two-numbers/description/
     */
    //需要考虑 两个都没有, 只有一个, 最后一个进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode result; // result Node.
        ListNode move;   // move Node.

        int sum = l1.val + l2.val;
        int resultVal = sum % 10;
        result = new ListNode(resultVal);
        move = result;
        int carry = sum / 10; //进位

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val + carry;
            resultVal = sum % 10;
            move.next = new ListNode(resultVal);
            move = move.next;
            carry = sum / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {

            if (carry == 0) {
                move.next = l1;
                return result;
            }

            sum = l1.val + carry;
            resultVal = sum % 10;
            move.next = new ListNode(resultVal);
            move = move.next;
            carry = sum / 10;
            l1 = l1.next;

        }

        while (l2 != null) {

            if (carry == 0) {
                move.next = l2;
                return result;
            }

            sum = l2.val + carry;
            resultVal = sum % 10;
            move.next = new ListNode(resultVal);
            move = move.next;
            carry = sum / 10;
            l2 = l2.next;

        }

        if (carry == 1) {
            move.next = new ListNode(carry);
        }

        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
