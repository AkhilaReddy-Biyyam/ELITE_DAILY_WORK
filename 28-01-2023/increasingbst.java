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
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode res=new TreeNode();
        TreeNode temp=res;
        for(int i=0;i<list.size();i++){
            temp.right=new TreeNode(list.get(i));
            temp=temp.right;
        }
        return res.right;
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
