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
    public int diameterOfBinaryTree(TreeNode root) {
        int maximum[]=new int[1];//to make it call by reference
        findHeight(root,maximum);
        return maximum[0];
    }
    public int findHeight(TreeNode root,int[] maximum){
        if(root==null){
            return 0;
        }
        int leftHeight=findHeight(root.left,maximum);
        int rightHeight=findHeight(root.right,maximum);
        maximum[0]=Math.max(maximum[0],leftHeight+rightHeight);

        return 1+Math.max(leftHeight,rightHeight);
    }
}