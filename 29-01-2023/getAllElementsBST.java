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
    List<Integer>list1=new ArrayList<>();
    List<Integer>list2=new ArrayList<>();
    List<Integer>res=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1,list1);
        inorder(root2,list2);
        res.addAll(list1);
        res.addAll(list2);
        Collections.sort(res);
        return res;

    }
    void inorder(TreeNode root,List<Integer>list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
