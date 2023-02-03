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
class Fields{ 
    TreeNode node;
    int offset;
    int level;
    Fields(TreeNode node, int offset, int level) {
        this.node=node;
        this.offset=offset;
        this.level=level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<Fields>q=new LinkedList<>();
        Fields f=new Fields(root,0,0);
        q.offer(f);
        
        while(!q.isEmpty()){
            Fields curr=q.poll();
            TreeNode currNode=curr.node;
            int currOffset=curr.offset;
            int currLevel=curr.level;
            
            if(!map.containsKey(currOffset))
                map.put(currOffset,new TreeMap<>());
            
            if(!map.get(currOffset).containsKey(currLevel))
                map.get(currOffset).put(currLevel,new PriorityQueue<>());
            
            map.get(currOffset).get(currLevel).offer(currNode.val);
            
            if(currNode.left!=null){
                Fields temp=new Fields(currNode.left,currOffset-1,currLevel+1);
                q.add(temp);
            }
            if(currNode.right!=null){
                Fields temp=new Fields(currNode.right,currOffset+1,currLevel+1);
                q.add(temp);
            }
        }
        
        List<List<Integer>>list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>secondMap:map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer>nodes:secondMap.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
