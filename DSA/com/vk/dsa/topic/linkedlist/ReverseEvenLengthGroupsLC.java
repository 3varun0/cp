package com.vk.dsa.topic.linkedlist;

/**
 * # Intuition
 * Use in-memory reverse.
 *
 * # Approach
 * ->Use in-memory reverse approach.
 * ->check if current group is last or not, i.e. no. of unprocessed nodes is >= 1 + processed_group_len, is it's NOT last then return -1 from isLastG(); method.
 * ->if not last group, then increament 'gLen' by 1 otherwise use lastGLen as 'gLen'
 * ->if, 'gLen' is add then do NOT reversing and skip 'gLen' no. of nodes of current odd group.
 * ->otherwise, start reversing "even" group nodes as follows:-
 *
 *     -NOTE : before reversing current even-group, the first-node of even-group will become the last-node of even-group, post reversing the order by changing the 'cur.next' pointer. Hence, we can take it's reference for backup in 'evenEnd'(variable) so that after reversing the even-group nodes the last node of even-group (i.e. 'evenEnd') can be further connected to next-group first node.
 *
 *     ex : evenEnd.next = next;
 *
 *     -Also, after reversing the even-group nodes 'prev' pointer would become the first-node of the reversed even-group. Hence it also need to be linked to last-node of previous group.
 *
 *     ex : prevGEnd.next = prev;
 *
 *     -Also after each reversing of even-group nodes, we need to keep updating the 'prevGEnd' pointer with 'evenEnd'.
 *
 * # Complexity
 * - Time complexity:
 * O(n)
 *
 * - Space complexity:
 * O(1)
 */
public class ReverseEvenLengthGroupsLC {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int gLen = 0;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        ListNode prevGEnd = null;
        ListNode evenEnd = null;
        int count = 0;
        int skip = 0;
        int isLastG = 0;
        boolean isNotLastGroup = false;

        while (cur != null) {
            isLastG = isLastG(cur, gLen);
            isNotLastGroup = isLastG == -1 ? true : false;
            if (isNotLastGroup) {
                gLen++;
            } else if (!isNotLastGroup) {
                gLen = isLastG;
            }

            if ((gLen & 1) == 0) {
                evenEnd = cur;

                //rev start
                count = gLen;
                prev = null;
                next = null;
                while (count-- != 0) {
                    next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }
                //rev end

                prevGEnd.next = prev;
                evenEnd.next = next;
                prevGEnd = evenEnd;
            } else {
                skip = gLen;
                while (skip-- != 0) {
                    prevGEnd = cur;
                    cur = cur.next;
                }
            }
        }
        return head;
    }

    public int isLastG(ListNode cur, int prevGLen) {
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
            if (count > (prevGLen+1)) {
                count = -1;
                break;
            }
        }
        return count;
    }
}
