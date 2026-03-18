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
    public int distributeCoins(TreeNode root) {
        if(root == null ||(root.left == null && root.right == null)){
            return 0;
        }
        int[] moves = {0};

        dfs(root , moves);

        return moves[0];
    }
    public int dfs(TreeNode node , int[] moves){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left , moves);// means extra or need from left
        int right = dfs(node.right , moves); // means extra or need from right

        moves[0] += Math.abs(left) + Math.abs(right);// here we need to take mod of left and right because we are calculating moves, (-ve -> need , +ve -> extra)

        int extraCandies = (node.val + left + right) - 1;//here we will not take mod of left and right because if extra or need means the candie is needed  , so if -ve means need

        return extraCandies;
    }
}