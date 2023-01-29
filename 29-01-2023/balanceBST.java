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
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return bst_from_inorder(0,list.size()-1);
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode bst_from_inorder(int low,int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode res=new TreeNode(list.get(mid));
        res.left=bst_from_inorder(low,mid-1);
        res.right=bst_from_inorder(mid+1,high);
        return res;
    }
}
