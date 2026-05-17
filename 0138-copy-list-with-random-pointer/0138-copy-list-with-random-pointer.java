/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Insert copy nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the copied list
        Node copyHead = head.next;
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) copy.next = copy.next.next;
            curr = curr.next;
        }

        return copyHead;
    }
}