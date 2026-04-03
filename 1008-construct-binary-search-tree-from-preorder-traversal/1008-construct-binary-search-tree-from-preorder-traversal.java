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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1; i<preorder.length; i++){
            TreeNode node = new TreeNode(preorder[i]);
            fun(root, node);
        }
        return root;
    }
    static void fun (TreeNode root, TreeNode node){
      
        if(root.right==null && root.left==null && node.val<root.val){
            root.left = node;
            return;
        }
        if(root.right==null && root.left==null && node.val>root.val){
            root.right = node;
            return;
        }
        if(root.right == null && root.left!=null && node.val>root.val) {root.right = node ; return;}
        if(root.left == null && root.right!=null && node.val<root.val) {root.left = node ; return; }

        if(node.val<root.val) fun(root.left, node);
        else fun(root.right, node);
    }

}