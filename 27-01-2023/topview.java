import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
class Fields{
	BinaryTreeNode root;
	int offset;
	Fields(){
	}
	Fields(BinaryTreeNode root,int offset){
		this.root=root;
		this.offset=offset;
	}
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
		ArrayList<Integer>topView=new ArrayList<>();
		if(root==null){
			return topView;
		}
		TreeMap<Integer,Integer>map=new TreeMap<>();
		Queue<Fields>queue=new LinkedList<>();
		Fields f=new Fields(root,0);
		queue.add(f);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				Fields curr=queue.poll();
				BinaryTreeNode currNode=curr.root;
				int currOffset=curr.offset;
				if(!map.containsKey(currOffset)){
					map.put(currOffset,currNode.val);
				}
				if(currNode.left!=null){
					Fields temp=new Fields(currNode.left,currOffset-1);
					queue.add(temp);
				}
				if(currNode.right!=null){
					Fields temp2=new Fields(currNode.right,currOffset+1);
					queue.add(temp2);
				}
			}
		}
		for(int key:map.keySet()){
			topView.add(map.get(key));
		}
		return topView;

	}
}
