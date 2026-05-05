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
        if(head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            length++;
            tail = tail.next;
        }

        if(k % length == 0) return head;
        
        tail.next = head;


        int move = length - k % length;

        ListNode newTail = head;
        for(int i = 1; i < move; i++){
            newTail = newTail.next;
        }

        ListNode newHead = new ListNode();

        newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }
}