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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> indexMap = new HashMap<>();
        // to hash the inorder values
        for(int i = 0; i < inorder.length; i++){
            indexMap.put(inorder[i] , i);
        }

        int n = preorder.length - 1;
        int m = inorder.length - 1;
        
        TreeNode root = buildTree(preorder , 0 , n , inorder , 0 , m , indexMap);

        return root;
    }

    public TreeNode buildTree(int[] preorder ,int preStart , int preEnd , int[] inorder , int inStart , int inEnd , Map<Integer , Integer> indexMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        int rootData = preorder[preStart];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);

        int leftTreeSize = rootIndex - inStart;
    
        root.left = buildTree(preorder , preStart + 1 , preStart + leftTreeSize , inorder , inStart , rootIndex - 1 , indexMap);
        root.right = buildTree(preorder , preStart + 1 + leftTreeSize , preEnd , inorder , rootIndex + 1 , inEnd , indexMap);

        return root;
    }
}