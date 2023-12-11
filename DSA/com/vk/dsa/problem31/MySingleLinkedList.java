package com.vk.dsa.problem31;

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
 * Problem 31 : deleteAfter(int data);
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }


    /**
     * Problem 31
     * @param data
     */
    public ListNode deleteAfter(int data) {
        ListNode current = head;
        ListNode deleted = null;
        while (current != null) {
            if (current.val == data) {
                deleted = current.next;
                current.next = deleted != null ? current.next.next : null;
                return deleted;
            }
            current = current.next;
        }
        return deleted;
    }

    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}