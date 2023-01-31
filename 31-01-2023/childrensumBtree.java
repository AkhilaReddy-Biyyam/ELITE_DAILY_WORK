import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.
        int diff;
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.left!=null){
            if(root.right!=null){
                diff=root.data-(root.left.data+root.right.data);
            }
            else
                diff=root.data-root.left.data;

        }
        else diff=root.data-root.right.data;
        if(diff>0){
            if(root.left!=null){
                root.left.data+=diff;
            }
            else{
                root.right.data+=diff;
            }
        }
        changeTree(root.left);
        changeTree(root.right);
        if(root.left!=null){
            if(root.right!=null){
                root.data=root.left.data+root.right.data;
            }
            else{
                root.data=root.left.data;
            }
        }
        else{
            if(root.right!=null){
                root.data=root.right.data;
            }
        }
    }
}
