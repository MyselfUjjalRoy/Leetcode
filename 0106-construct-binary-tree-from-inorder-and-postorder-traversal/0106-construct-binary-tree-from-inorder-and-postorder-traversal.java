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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i] , i);
        }

        int m = inorder.length - 1;
        int n = postorder.length - 1;

        TreeNode root = buildTree(inorder , 0 , m , postorder , 0 , n , map);

        return root;
    }

    public TreeNode buildTree(int[] inorder , int inStart , int inEnd , int[] postorder , int postStart , int postEnd , Map<Integer , Integer> map){
        if(inStart > inEnd || postStart > postEnd){
            return null;
        }

        int rootData = postorder[postEnd];
        int rootIdx = map.get(rootData);
        TreeNode root = new TreeNode(rootData);

        int leftTreeSize = rootIdx - inStart;

        root.left = buildTree(inorder , inStart , rootIdx - 1 , postorder , postStart , postStart + leftTreeSize - 1 , map);
        root.right = buildTree(inorder , rootIdx + 1 , inEnd , postorder , postStart + leftTreeSize , postEnd - 1 , map);

        return root;
    }
}