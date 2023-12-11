package com.vk.dsa.problem33;

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
 * Problem 33 : findLoopNode();
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }


    /**
     * Problem 33
     * Detect a loop in LinkedList
     */
    public ListNode findLoopNode() {
        ListNode cur = head;
        ListNode fast = cur;
        ListNode slow = cur;
        while (cur.next != null) {
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
            }
            if (fast == slow) {
                return slow;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}