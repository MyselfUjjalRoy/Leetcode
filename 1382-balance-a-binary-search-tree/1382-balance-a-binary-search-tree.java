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
    public void inorder(TreeNode root , List<Integer> nodes){
        if(root == null) return;
        
        inorder(root.left , nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    public TreeNode buildBalancedBST(List<Integer> nodes, int start , int end){
        if(start > end) return null;

        int mid = (start + end) / 2;
        int midNode = nodes.get(mid);

        TreeNode root = new TreeNode(midNode);

        root.left  = buildBalancedBST(nodes , start , mid - 1);
        root.right = buildBalancedBST(nodes , mid + 1 , end);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        
        inorder(root , nodes);

        return buildBalancedBST(nodes , 0 , nodes.size() - 1);
    }
}