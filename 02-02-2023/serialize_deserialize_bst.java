/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)  return "";
        Queue<TreeNode>queue=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp==null) {   
                res.append("# ");
                continue;
            }
            res.append(temp.val+" ");
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String ans[]=data.split(" ");
        Queue<TreeNode>queue2=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(ans[0]));
        queue2.add(root);
        for(int i=1;i<ans.length;i++){
            TreeNode temp=queue2.poll();
            if(!ans[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(ans[i]));
                temp.left=left;
                queue2.add(left);
            }
            if(!ans[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(ans[i]));
                temp.right=right;
                queue2.add(right);
            }
        }

        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
