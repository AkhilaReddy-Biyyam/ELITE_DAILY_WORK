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
    int index=0;
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],map.getOrDefault(inorder[i],i));
        }
        return build_from_Pre_In(preorder,0,preorder.length-1);
    }
    TreeNode build_from_Pre_In(int[] preorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[index]);
        index++;
        root.left=build_from_Pre_In(preorder,left,map.get(root.val)-1);
        root.right=build_from_Pre_In(preorder,map.get(root.val)+1,right);
        return root;
    }
}
