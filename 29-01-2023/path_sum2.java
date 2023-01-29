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
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer>list=new ArrayList<>();
        paths(root,targetSum,list);
        return res;
    }
    void paths(TreeNode root,int remainingsum,List<Integer>list){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.val==remainingsum && root.left==null && root.right==null){
            res.add(list);
            return;
        }
        paths(root.left,remainingsum-root.val,new ArrayList<Integer>(list));
        paths(root.right,remainingsum-root.val,new ArrayList<Integer>(list));
    }
}

