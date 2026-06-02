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
class Solution { // Morris Traversal inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            //case 1 : no left subtree
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;

                // find inorder predecessor
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                // create thread
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                // thread already exists
                else{
                    prev.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}