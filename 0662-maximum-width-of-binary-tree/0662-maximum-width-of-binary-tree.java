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
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode node , long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = Integer.MIN_VALUE;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root , 0)); // [node , index]

        while(!queue.isEmpty()){
            int size = queue.size();
            long firstIdx = 0 , lastIdx = 0;
            
            long minIdx = queue.peek().index;

            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();

                long currIdx = curr.index - minIdx; // to avoid the overflow

                if(i == 0) firstIdx = currIdx;
                if(i == size - 1) lastIdx = currIdx;

                if(curr.node.left != null){
                    queue.offer(new Pair(curr.node.left , 2 * currIdx + 1));
                }
                if(curr.node.right != null){
                    queue.offer(new Pair(curr.node.right , 2 * currIdx + 2));
                }
            }

            maxWidth = Math.max(maxWidth , (int)(lastIdx - firstIdx + 1));
        }

        return maxWidth;
    }
}