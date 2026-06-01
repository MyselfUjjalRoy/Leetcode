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
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        findSum(root);

        return maxPathSum;
    }

    public int findSum(TreeNode node){
        if(node == null) return 0;

        int leftSum = Math.max(findSum(node.left) , 0);
        int rightSum = Math.max(findSum(node.right) , 0);

        maxPathSum = Math.max(maxPathSum , leftSum + rightSum + node.val);

        return node.val + Math.max(leftSum , rightSum);
    }
}