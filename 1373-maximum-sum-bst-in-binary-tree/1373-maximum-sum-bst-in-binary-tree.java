/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    class Node {
        int minNode , maxNode , maxSum;
        Node(int minNode , int maxNode , int maxSum){
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSum = maxSum;
        }
    }

    public Node maxSumBSTHelper(TreeNode root){
        if(root == null){
            return new Node(Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }

        Node left = maxSumBSTHelper(root.left);
        Node right = maxSumBSTHelper(root.right);

        //curr subtree is a BST
        if(left.maxNode < root.val && root.val < right.minNode){
            int currSum = left.maxSum + right.maxSum + root.val;

            ans = Math.max(ans , currSum);

            return new Node(Math.min(root.val , left.minNode) ,
            Math.max(root.val , right.maxNode) , currSum);
        }

        // not a BST
        return new Node(Integer.MIN_VALUE , Integer.MAX_VALUE , 0);
    }
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return ans;
    }
}