package com.vk.dsa.problem29;

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
 * Problem 29 : insertBefore(int beforeThis, int val);
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    /**
     * Problem 29
     * @param beforeThis
     * @param val
     */
    public void insertBefore(int beforeThis, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            return;
        }

        if (head.val == beforeThis) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ListNode current = head;
        ListNode prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
            if (current.val == beforeThis) {
                prev.next = newNode;
                newNode.next = current;
            }
            return;
        }
    }


    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}