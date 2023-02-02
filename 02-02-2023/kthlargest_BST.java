import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
		ArrayList<Integer>list=new ArrayList<>();
		inorder(root,list);
		if(list.size()<k) 
			return -1;
        return list.get(list.size()-k);
	}
	static void inorder(TreeNode root,ArrayList<Integer>list){
        if(root==null) return;
        inorder(root.left,list);
        list.add((int)root.data);
        inorder(root.right,list);
    }
}


