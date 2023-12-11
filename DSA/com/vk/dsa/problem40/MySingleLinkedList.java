package com.vk.dsa.problem40;

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

    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();
        ll.addAtTail(100);
        ll.addAtTail(90);
        ll.addAtTail(80);
        ll.addAtTail(70);
        ll.addAtTail(60);
        ll.addAtTail(50);
        ll.addAtTail(40);
        ll.addAtTail(30);
        ll.addAtTail(20);
        ll.addAtTail(10);

        int tailPos = 3;
        System.out.println(ll.getNodeFromTail(tailPos));

    }

    /**
     * two pointers approach ('later' and 'now' pointers)
     * 'later' pointer should be started after 'tailPos' no.s of moves of 'now' pointer.
     * @param tailPos
     * @return
     */
    private int getNodeFromTail(int tailPos) {
        ListNode now = head;
        ListNode later = head;

        for (int i=0; now.next != null; i++) {
            now = now.next;
            if (i >= tailPos) {
                later = later.next;
            }
        }
        return later.val;

    }
}