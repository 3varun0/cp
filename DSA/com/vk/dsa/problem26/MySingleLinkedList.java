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
 * Problem 26 : addAtHead(int val);         done
 * Problem 27 : addAtTail(int val);         done
 * Problem 28 : insertAfter(int afterThis, int val)     done
 * Problem 29 : insertBefore(int beforeThis, int val);  done
 * Problem 30 : deleteLast();               done
 * Problem 31 : deleteNext(int data);       done
 * Problem 32 : delete();
 * Problem 33 : findLoopNode();
 * Problem 34 : getIntersectingNode();
 * Problem 35 : isLinkedListEven();
 * <p>
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

    /**
     * Problem 28
     * @param afterThis
     * @param val
     */
    public void insertAfter(int afterThis, int val) {
        ListNode newNode = new ListNode(10);

        ListNode current = head;
        if (current == null) {
            head = newNode;
            return;
        }

        while (current != null) {
            if (current.val == afterThis) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
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


    /**
     * Problem 30
     */
    public ListNode deleteLast() {
        ListNode current = head;
        ListNode prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        return current;
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
        ll.addAtHead(1);
        ll.addAtTail(2);
        ll.addAtIndex(1, 2);
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
