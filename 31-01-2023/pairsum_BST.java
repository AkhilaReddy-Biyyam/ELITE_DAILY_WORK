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

//Using BST iterator
 class BSTIteraror{
	private Stack<TreeNode>stack=new Stack<TreeNode>();
	boolean reverse=true;
	public BSTIteraror(TreeNode root,boolean isReverse){
		reverse=isReverse;
		pushAll(root);
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public int next(){
	    TreeNode node=stack.pop();
		if(reverse==false) pushAll(node.right);
		else pushAll(node.left);
		return node.val;
	}
	private void pushAll(TreeNode t){
		while(t!=null){
			stack.push(t);
			if(reverse==false) t=t.left;
			else t=t.right;
		}
	}
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
		BSTIteraror forward=new BSTIteraror(root,false);
		BSTIteraror rev=new BSTIteraror(root,true);
		int i=forward.next();
		int j=rev.next();
		while(i<j){
			if(i+j==k) return true;
			else if(i+j<k) i=forward.next();
			else j=rev.next();
		}
		return false;
    }
}

//Using arraylist of inorder
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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer>list=new ArrayList<>();
		inorder(root,list);
		if(list.size()==1) return false;
		int left=0;
		int right=list.size()-1;
		while(left<right){
			int temp=list.get(left)+list.get(right);
			if(temp==k)
				return true;
			else if(temp>k)
				right=right-1;
			else
				left=left+1;
		}
		return false;
    }
    void inorder(TreeNode root,ArrayList<Integer>list){
		if(root==null) return;
		inorder(root.left,list);
		list.add(root.val);
		inorder(root.right,list);
    }
}
