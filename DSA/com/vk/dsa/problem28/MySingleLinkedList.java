package com.vk.dsa.problem28;

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
 * Problem 28 : insertAfter(int afterThis, int val);
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    /**
     * Problem 28
     * @param afterThis
     * @param val
     */
    public void insertAfter(int afterThis, int val) {
        ListNode newNode = new ListNode(10);

        ListNode current = head;
        if (current == null) {
            head = newNode;
            return;
        }

        while (current != null) {
            if (current.val == afterThis) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}