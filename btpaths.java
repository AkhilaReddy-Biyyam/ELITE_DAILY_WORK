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
    ArrayList<String> list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String res="";
        paths(root,res);
        return list;
    }
    void paths(TreeNode root, String res) {
        if(root==null) return;
        res=res+root.val;
        if(root.left==null && root.right==null){
            list.add(res);
            return;
        }
        res=res+"->";
        paths(root.left,res);
        paths(root.right,res);
    }
}