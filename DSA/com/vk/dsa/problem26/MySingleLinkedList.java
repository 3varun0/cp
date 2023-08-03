package com.vk.dsa.problem26;

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
 * Problem 26 : addAtHead(int val);
 *
 * deleteAtIndex(int index);                done
 * addAtIndex(int index, int val);          done
 * get(int index)                           done

 */
class MySingleLinkedList {

    ListNode head;

    public MySingleLinkedList() {
        head = null;
    }

    /**
     * Problem 26.
     *
     * @param val
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, head);
        head = newNode;
    }

    public void addAtIndex(int index, int val) {

        if (head == null && index > 0) {
            return;
        }
        ListNode newNode = new ListNode(val);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        int i = 1;
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null || index == i) {

            if (index == i) {
                newNode.next = current;
                prev.next = newNode;
                return;
            }

            i++;
            prev = current;
            current = current.next;
        }

    }

    public void deleteAtIndex(int index) {

        if (0 == index) {
            head = head.next;
            return;
        }

        int i = 1;
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null) {

            if (i == index) {
                prev.next = current.next;

            }
            i++;
            prev = current;
            current = current.next;
        }


    }

    public int get(int index) {
        int val = -1;
        //if (index < 0) {
        //    return -1;
        // }

        ListNode current = head;
        int i = 0;
        while (current != null) {
            if (index == i) {
                return current.val;
            }
            i++;
            current = current.next;
        }
        return val;
    }


    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();

    }
}