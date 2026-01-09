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
    Map<Integer , Integer> map = new HashMap<>();
    int maxDepth = 0;
    public void findDepth(TreeNode root , int depth){
        if(root == null){
            return;
        }
        maxDepth = Math.max(maxDepth , depth);
        map.put(root.val , depth);
        findDepth(root.left , depth + 1);
        findDepth(root.right , depth + 1);
    }
    public TreeNode LCA(TreeNode root){
        if(root == null || map.getOrDefault(root.val , -1) == maxDepth){
            return root;
        }
        TreeNode left = LCA(root.left);
        TreeNode right = LCA(root.right);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findDepth(root , 0);
        return LCA(root);
    }
}