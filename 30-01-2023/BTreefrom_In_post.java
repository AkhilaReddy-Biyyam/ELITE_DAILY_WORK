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
    int index;
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],map.getOrDefault(inorder[i],i));
        }
        return build_from_Post_In(postorder,0,postorder.length-1);
    }
    TreeNode build_from_Post_In(int[] postorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[index]);
        index--;
        root.right=build_from_Post_In(postorder,map.get(root.val)+1,right);
        root.left=build_from_Post_In(postorder,left,map.get(root.val)-1);
        return root;
    }
}

