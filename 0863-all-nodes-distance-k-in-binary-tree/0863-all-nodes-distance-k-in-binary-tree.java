/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode start, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        TreeNode startNode = buildParentMap(root , parent , start);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        int distance = 0;

        while(!queue.isEmpty()){
            if(distance == k){
                ArrayList<Integer> list = new ArrayList<>();
                for(TreeNode node : queue){
                    list.add(node.val);
                }
                return list;
            }
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                    visited.add(parent.get(node));
                    queue.offer(parent.get(node));
                }
            }
            distance++;
        }
        return new ArrayList<>();
    }
    public TreeNode buildParentMap(TreeNode root , Map<TreeNode , TreeNode> parent , TreeNode start){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode startNode = null;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node == start){
                startNode = node;
            }

            if(node.left != null){
                queue.offer(node.left);
                parent.put(node.left, node);
            }

            if(node.right != null){
                queue.offer(node.right);
                parent.put(node.right , node);
            }
        }
        return startNode;
    }
}