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
    ArrayList<Integer>list=new ArrayList<>();
    ArrayList<Integer>res=new ArrayList<>();
    HashMap<Integer,Integer>map=new HashMap<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        for(int x:list){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int maxFreq=maxFrequency(map);
        for(int k:map.keySet()){
            if(map.get(k)==maxFreq){
                res.add(k);
            }
        }
        int [] arr=new int [res.size()];
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;

    }
    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    int maxFrequency(HashMap<Integer,Integer>map){
        int maxx=0;
        for(int key:map.keySet()){
            if(map.get(key)>maxx){
                maxx=map.get(key);
            }
        }
        return maxx;
    }
}
