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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>queue= new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.peek()!=null) {
            TreeNode curr= queue.poll();
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        while (!queue.isEmpty() && queue.peek() == null)
            queue.poll();
        return queue.isEmpty();
    }
}
