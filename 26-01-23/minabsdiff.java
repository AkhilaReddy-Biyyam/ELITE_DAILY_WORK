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
    int min=Integer.MAX_VALUE;
    ArrayList<Integer>list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        for(int i=1;i<list.size();i++){
            int curr=list.get(i)-list.get(i-1);
            if((curr)<min){
                min=curr;
            }
        }
        return min;
    }
    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
