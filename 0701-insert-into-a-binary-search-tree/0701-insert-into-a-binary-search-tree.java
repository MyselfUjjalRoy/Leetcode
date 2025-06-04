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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode curr = root;
        while(curr != null){
            if(val < curr.val){
                if(curr.left == null){
                    TreeNode node = new TreeNode(val);
                    curr.left = node;
                    break;
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.right == null){
                    TreeNode  node = new TreeNode(val);
                    curr.right = node;
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}