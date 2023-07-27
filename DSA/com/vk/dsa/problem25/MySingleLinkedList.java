package com.vk.dsa.problem25;

class ListNode {

        int val;
        ListNode next;

        public ListNode (int val) {this.val = val;}
        public ListNode (int val, ListNode next) {this.val = val; this.next = next;}
}

class MySingleLinkedList {

        ListNode head;

        public MySingleLinkedList() {
            head = null;
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

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val, head);
            head = newNode;
        }

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

        public void insertFirst(int data) {

        }

        public void printList() {

        }
        public void insertLast(int data) {

        }

        public void insertAfter(int afterThis, int data) {

        }

        public void insertBefore(int beforeThis, int data) {

        }

        public void deleteLast () {

        }

        public void deleteAfter(int data) {

        }

        public void deleteNode (int data) {

        }
        public void detectLoop () {

        }

        public ListNode findIntersectionNode() {


            return null;
        }

        public boolean isListEvenLength() {

            return false;
        }

        public ListNode deleteStart () {

        }


    public static void main(String[] args) {
        MySingleLinkedList ll = new MySingleLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(2);
        ll.addAtIndex(1,2);
        System.out.println(ll.get(1));
        ll.deleteAtIndex(1);
        System.out.println(ll.get(1));

        //expected output : [null,null,null,null,2,null,3]
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
