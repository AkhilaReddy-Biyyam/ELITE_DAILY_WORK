import java.util.* ;
import java.io.*; 
 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code here
		 int upper=Integer.MAX_VALUE;
		 return createTree(preOrder,upper,new int[] {0});
	}
	public static TreeNode createTree(int [] preorder,int upper,int[] curr){
		if(curr[0]==preorder.length) return null;
		if(preorder[curr[0]]>upper) return null;
		TreeNode root=new TreeNode(preorder[curr[0]++]);
		root.left=createTree(preorder,(int)root.data, curr);
		root.right=createTree(preorder, upper, curr);
		return root;
	}

}
