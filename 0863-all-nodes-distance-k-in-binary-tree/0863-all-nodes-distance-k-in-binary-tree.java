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
        Map<TreeNode , TreeNode> parentMap = new HashMap<>();

        buildParentMap(root , parentMap);

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int distance = 0;

        while(!queue.isEmpty()){
            if(distance == k){
                List<Integer> ans = new ArrayList<>();
                for(TreeNode node : queue){
                    ans.add(node.val);
                }

                return ans;
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
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
            distance++;
        }

        return new ArrayList<>();
    }

    public void buildParentMap(TreeNode root , Map<TreeNode , TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null){
                parentMap.put(node.left , node);
                queue.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right , node);
                queue.offer(node.right);
            }
        }


    }
}