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
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
		ArrayList<Integer>list=new ArrayList<>();
		int predecessor=-1;
		int successor=-1;
		while(root.data!=key){
			if(root.data<key){
				predecessor=root.data;
				root=root.right;
			}
			else{
				successor=root.data;
				root=root.left;
			}
		}
		BinaryTreeNode<Integer> rightTree=root.right;
		while(rightTree!=null){
			successor=rightTree.data;
			rightTree=rightTree.left;
		}
		BinaryTreeNode<Integer> leftTree=root.left;
		while(leftTree!=null){
			predecessor=leftTree.data;
			leftTree=leftTree.right;
		}
		list.add(predecessor);
		list.add(successor);
		return list;

	}
	
}
