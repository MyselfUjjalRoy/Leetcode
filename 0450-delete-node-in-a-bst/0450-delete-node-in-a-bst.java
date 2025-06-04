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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(key < root.val){
            root.left = deleteNode(root.left , key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right , key);
        }
        else{
            //means the key found

            if(root.left == null && root.right == null){//means no child
                return null;
            }
            //When single child
            if(root.left == null){//having only right child
                return root.right;
            }
            else if(root.right == null){//having only left child
                return root.left;
            }
            else{
                TreeNode inorderPredecessor = findMin(root.right);
                root.val = inorderPredecessor.val;
                root.right = deleteNode(root.right , inorderPredecessor.val);
            }
        }
        return root;
    }
    public TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}