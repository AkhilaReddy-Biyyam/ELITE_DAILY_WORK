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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double>res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            double sum=0;
            double avg;
            ArrayList<Integer>list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                list.add(curr.val);
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            for(int i:list){
                sum+=i;
            }
            avg=sum/list.size();
            res.add(avg);
        }
        return res;
        
    }
}
