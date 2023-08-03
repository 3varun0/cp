package com.vk.dsa.problem34;

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
 * Problem 34 : getIntersectingNode(ListNode headA, ListNode headB);
 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }


    /**
     * Problem 34
     * Given are two LinkedLists.
     * Both are insecting each other at a node.
     * Find the intersecting node.
     *
     * Solution :
     * Four approaches are there :
     * 1. Using two stacks.
     * 2. Using p1 and p2 pointers
     * 3. Using p1 and p2 pointers along with size of LinkedLists
     * 4. Using p1 and p2 pointers. below solution is using this approach.
     */
    public ListNode getIntersectingNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1.next == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2.next == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }


    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}