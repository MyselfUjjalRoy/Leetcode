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
    public ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 1) {
            curr = curr.next;
            k--;
        }

        return curr;
    }

    public void reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while (temp != null) {
            ListNode kth_Node = getKthNode(temp, k);
            if (kth_Node == null) {
                if (prevLast != null)
                    prevLast.next = temp; // 1->2 , k = 3
                break;
            }

            ListNode nextNode = kth_Node.next;
            kth_Node.next = null;
            reverseLL(temp);
            if (temp == head) { // 1st time reversal
                head = kth_Node;
            } else {
                prevLast.next = kth_Node;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

}