package com.vk.dsa.topic.linkedlist;

/**
 * # Intuition
 * In-memory reversal
 *
 * # Approach
 * <!-- Describe your approach to solving the problem. -->
 *
 * # Complexity
 * - Time complexity:
 * O(n)
 *
 * - Space complexity:
 * O(1)
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        ListNode leftPartPrev = null;
        ListNode revEnd = null;
        boolean isRevStart = false;
        int pos = 0;

        while (cur != null) {
            pos++;
            if (pos == left) {
                isRevStart = true;
                revEnd = cur;
            }

            if (isRevStart) {
                //rev start
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                //rev end
                if (pos == right) {
                    break;
                }
            } else {
                leftPartPrev = cur;
                cur = cur.next;
            }
        }

        if (isRevStart) {
            if (left == 1) {
                if (next == null) {//is entire list is reversed
                    return prev;
                }
                head = prev;
            } else {
                leftPartPrev.next = prev;
            }
            revEnd.next = next;
        }
        return head;

    }
}
