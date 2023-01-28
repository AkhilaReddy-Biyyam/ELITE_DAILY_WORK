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
    StringBuilder res=new StringBuilder();
    public String tree2str(TreeNode root) {
        sfromB(root);
        return res.toString();
    }
    void sfromB(TreeNode root){
        if(root==null) return;
        res.append(String.valueOf(root.val));
        if(root.left==null && root.right==null){
            return;
        }
        res.append('(');
        sfromB(root.left);
        res.append(')');
        if(root.right!=null){
            res.append("(");
            sfromB(root.right);
            res.append(")");
        }

    }
}
