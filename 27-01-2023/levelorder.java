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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer>list=new ArrayList<>();
        list.add(root.val);
        res.add(list);
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer>l=new ArrayList<>();
            int size=queue.size();
            for(int i=1;i<=size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null){
                    l.add(curr.left.val);
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    l.add(curr.right.val);
                    queue.add(curr.right);
                }
            }
            if(l.size()>0){ 
                res.add(l);
            }
        }
        return res;

    }

}
