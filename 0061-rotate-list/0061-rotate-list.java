/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
        public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        if(k % length == 0) return head;

        tail.next = head;

        int shift = length - (k % length);

        for(int i = 0; i < shift - 1; i++){
            head = head.next;
        }

        ListNode newHead = head.next;

        head.next = null;

        return newHead;
    }
}