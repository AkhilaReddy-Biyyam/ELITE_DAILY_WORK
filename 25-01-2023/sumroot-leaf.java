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
    ArrayList<Integer>list=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        String res="";
        int total=0;
        paths(root,res);
        for(int num:list){
            total=total+num;
        }
        return total;
    }
    void paths(TreeNode root,String res){
        if(root==null){
            return;
        }
        res+=root.val;
        if(root.left==null && root.right==null){
            list.add(Integer.parseInt(res));
            return;
        }
        paths(root.left,res);
        paths(root.right,res);
    }
}
