package com.vk.dsa.topic.linkedlist;

/**
 * This problem is from LC.
 *
 * Problem : Delete a node from given LinkedList
 * There is a singly-linked list head and we want to delete a node node in it.
 *
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 *
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 *
 * Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
 *
 *     The value of the given node should not exist in the linked list.
 *     The number of nodes in the linked list should decrease by one.
 *     All the values before node should be in the same order.
 *     All the values after node should be in the same order.
 */
public class DeleteANodeLC {

    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;

        while(cur.next != null) {
            cur.val = cur.next.val;
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
    }
}
class ListNode {
    int val;
    ListNode next;

}