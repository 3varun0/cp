package com.vk.dsa.problem30;

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
 * Problem 300 : deleteLast();
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    /**
     * Problem 30
     */
    public ListNode deleteLast() {
        ListNode current = head;
        ListNode prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        return current;
    }

    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}