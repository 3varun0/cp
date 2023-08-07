package com.vk.dsa.problem35;

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

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }



    /**
     * Problem 35
     */
    public boolean isLinkedListEven() {
        ListNode cur = head;
        if (cur != null) {
            while (cur.next != null) {
                cur = cur.next.next;
                if (cur == null) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();
        ll.addAtTail(10);
        ll.addAtTail(20);
        ll.addAtTail(30);
        ll.addAtTail(40);
        //ll.addAtTail(50);

        System.out.println(ll.isLinkedListEven());

    }
}