import java.util.* ;
import java.io.*; 
/*********************************************

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

*********************************************/


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
	public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
		// Write your code here.
		ArrayList<Integer>bottom_View=new ArrayList<>();
		if(root==null){
			return bottom_View;
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
				map.put(currOffset,currNode.val);
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
			bottom_View.add(map.get(key));
		}
		return bottom_View;

	}
}
