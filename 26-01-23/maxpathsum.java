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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;

    }
    int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=sum(root.left);
        int right=sum(root.right);
        maxSum=Math.max(maxSum,left+right+root.val);
        int temp=Math.max(left+root.val,right+root.val);
        return Math.max(temp,0);
    }
    
}
