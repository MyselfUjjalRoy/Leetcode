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
        int row , col;
        Pair(TreeNode node , int row , int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> colMap = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root , 0 , 0)); // [node.val , row , col]

        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            colMap.putIfAbsent(col , new TreeMap<>());
            colMap.get(col).putIfAbsent(row , new PriorityQueue<>());
            colMap.get(col).get(row).offer(node.val);

            if(node.left != null){
                queue.offer(new Pair(node.left , row + 1 , col - 1));
            }
            if(node.right != null){
                queue.offer(new Pair(node.right , row + 1 , col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer , PriorityQueue<Integer>> rowMap : colMap.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rowMap.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}