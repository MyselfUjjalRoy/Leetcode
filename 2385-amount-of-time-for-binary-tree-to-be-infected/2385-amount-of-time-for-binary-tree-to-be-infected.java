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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        TreeNode startNode = buildParentMap(root, start , parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);

        int time = -1; // as the starting node is already infected

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
            time++;
        }

        return time;
    }

    public TreeNode buildParentMap(TreeNode root, int start , Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode startNode = null;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if(node.val == start) startNode = node;

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        return startNode;
    }
}