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
class BSTIterator{
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;
    BSTIterator(TreeNode root , boolean reverse){
        this.reverse = reverse;
        pushAll(root);
    }

    public void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if(!reverse){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
    }

    public int next(){
        TreeNode curr = stack.pop();
        int value = curr.val;

        if(!reverse){
            pushAll(curr.right);
        }
        else{
            pushAll(curr.left);
        }

        return value;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        BSTIterator forward = new BSTIterator(root , false);
        BSTIterator reverse = new BSTIterator(root , true);

        int i = forward.next();
        int j = reverse.next();

        while(i < j){
            int sum = i + j;

            if(sum == k){
                return true;
            }

            if(sum < k){
                i = forward.next();
            }
            else{
                j = reverse.next();
            }
        }

        return false;
    }
}