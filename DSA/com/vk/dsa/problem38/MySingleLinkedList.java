package com.vk.dsa.problem38;

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
 * Problem 35 : isLinkedListEven();
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    public void addAtTail (int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return ;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }


    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();
        ll.addAtTail(10);
        ll.addAtTail(20);
        ll.addAtTail(30);
        ll.addAtTail(40);
        ll.addAtTail(50);


        MySingleLinkedList ll2 = new MySingleLinkedList();
        ll2.addAtTail(10);
        ll2.addAtTail(20);
        ll2.addAtTail(30);
        ll2.addAtTail(440);
        ll2.addAtTail(50);

        ll.compareList(ll2);


    }

    private boolean compareList(MySingleLinkedList ll2) {
        if (this == null && ll2 == null) {
            return true;
        } else if (this == null || ll2 == null) {
            return false;
        }
        return false;
    }
}