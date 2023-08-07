package com.vk.dsa;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

        ll.addAtTail(1);
        ll.addAtTail(2);
        ll.addAtTail(3);
        //ll.addAtTail(4);
        //ll.addAtTail(5);

        ll.head = ll.reverseBetween(ll.head, 1, 2);

        //printing
        ListNode cur = ll.head;
        while (cur != null) {
            System.out.println(cur.val+", ");
            cur = cur.next;
        }

    }
}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 *
 * Problem 27 : addAtTail(int val);
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    /**
     * Problem 27
     *
     * @param val
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val, null);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        ListNode leftPartPrev = null;
        ListNode revEnd = null;
        boolean isRevStart = false;
        int pos = 0;

        while (cur != null) {
            pos++;
            if (pos == left) {
                isRevStart = true;
                revEnd = cur;
            }

            if (isRevStart) {
                //rev start
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                //rev end
                if (pos == right) {
                    break;
                }
            } else {
                leftPartPrev = cur;
                cur = cur.next;
            }
        }

        if (isRevStart) {
            if (left == 1) {
                if (next == null) {//is entire list is reversed
                    return prev;
                }
                head = prev;
            } else {
                leftPartPrev.next = prev;
            }
            revEnd.next = next;
        }
        return head;

    }
}