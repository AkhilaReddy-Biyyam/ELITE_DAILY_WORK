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
    int res=0;
    public int sumRootToLeaf(TreeNode root) {
        int curr=0;
        preorder(root,curr);
        return res;
    }
    void preorder(TreeNode root,int curr){
        if(root==null) return;
        curr=(curr*2)+root.val;
        if(root.left==null && root.right==null){
            res+=curr;
        }
        preorder(root.left,curr);
        preorder(root.right,curr);
        
    }
}


