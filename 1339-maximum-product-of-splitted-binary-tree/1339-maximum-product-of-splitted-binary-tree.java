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
    long maxProd = 0;
    long totalSum = 0;
    long MOD = 1_000_000_007L;
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;

        totalSum = calculate(root);
        calculate(root);

        return (int)(maxProd % MOD);
    }
    public long calculate(TreeNode root){
        if(root == null) return 0;
        
        long leftSubTreeSum = calculate(root.left);
        long rightSubTreeSum = calculate(root.right);

        long currSum = root.val + leftSubTreeSum + rightSubTreeSum;
        maxProd = Math.max(maxProd , currSum * (totalSum - currSum));

        return currSum;
    }
}