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
    int maximumPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaximumPathSum(root);
        return maximumPathSum;        
    }
    public int getMaximumPathSum(TreeNode node){
        if(node == null) return 0;
        
        int lTreeSum = Math.max(getMaximumPathSum(node.left) , 0);
        int rTreeSum = Math.max(getMaximumPathSum(node.right) , 0);

        int currentPathSum = node.val + lTreeSum + rTreeSum;
        maximumPathSum = Math.max(maximumPathSum , currentPathSum);

        return node.val + Math.max(lTreeSum , rTreeSum);
    }
}