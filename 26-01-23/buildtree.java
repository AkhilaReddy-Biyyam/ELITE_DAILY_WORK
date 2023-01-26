# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if(len(inorder)==0 or len(postorder)==0):
            return None
        root=TreeNode(postorder[-1])
        postorder.pop()
        index=inorder.index(root.val)
        root.right=self.buildTree(inorder[index+1:],postorder)
        root.left=self.buildTree(inorder[:index],postorder)
        return root
        

      
