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
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height != -1;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;

        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);

        if(leftTreeHeight == -1 || rightTreeHeight == -1) return -1;
        if(Math.abs(leftTreeHeight - rightTreeHeight) > 1){
            return -1;
        }

        return 1 + Math.max(leftTreeHeight , rightTreeHeight);
    }
}