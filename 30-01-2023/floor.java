import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int x) {
        //    Write your code here.
        int floor=-1;
        while(root!=null){
            if(root.data<=x)
                floor=root.data;
            if(x==root.data)
                return (int)root.data;
            
            
            else if(x<root.data)
                root=root.left;
            else
                root=root.right;
        }
        return floor;
    }
}
