package com.vk.dsa.problem44;

import java.util.Stack;

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
 * Problem 44 : print LL(immutable) in reverse(int val);
 */
class MySingleLinkedList {

    private ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    /**
     * Problem 27 : addAtTail(int val);
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

    /**
     * printReverse();
     */
    public void printReverse() {

        Stack<Integer> st = new Stack<>();
        ListNode cur = getHead();
        while (cur != null) {
            st.push(cur.val);
            cur = cur.next;
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    public ListNode getHead() {
        return head;
    }



    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();
        ll.addAtTail(10);
        ll.addAtTail(20);
        ll.addAtTail(30);
        ll.addAtTail(40);
        ll.addAtTail(50);

        System.out.println("Printing original LinkedList : ");
        ListNode cur = ll.getHead();
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

        System.out.println("Printing immutable LinkedList in reverse order");
        ll.printReverse();

    }
}