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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res=new LinkedList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        boolean forward=true;
        while(!queue.isEmpty()){
            List<Integer>list=new LinkedList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(forward){
                    list.add(curr.val);
                }
                else{
                    list.add(0,curr.val);
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            res.add(list);
            forward=!forward;
        }
        return res;
    }
}
