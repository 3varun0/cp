package com.vk.dsa.problem32;

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
 * Problem 32 : delete(int data);
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }


    /**
     * Problem 32
     * @param data
     */
    public ListNode delete(int data) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (cur.val == data) {
                if (prev == null) {
                    head = cur.next;
                    cur.next = null;
                    return cur;
                } else {
                    prev.next = cur.next;
                    return cur;
                }
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}