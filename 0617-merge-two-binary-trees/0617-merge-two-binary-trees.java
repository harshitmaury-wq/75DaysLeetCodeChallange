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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        if(root1==null){
            root1 = new TreeNode(0);
        }
        if(root2==null){
            root2 = new TreeNode(0);
        }

        fun(root1, root2);
        return root1;
    }
    static void fun (TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return;
        

        root1.val = root1.val+root2.val ;
        if(root1.left != null && root2.left==null){
            TreeNode node = new TreeNode(0);
            root2.left = node ;
        } 
        if(root1.left == null && root2.left!=null){
            TreeNode node = new TreeNode(0);
            root1.left = node ;
        }
        if(root1.right != null && root2.right==null){
            TreeNode node = new TreeNode(0);
            root2.right = node ;
        }
        if(root1.right == null && root2.right!=null){
            TreeNode node = new TreeNode(0);
            root1.right = node ;
        }
        fun(root1.left, root2.left);
        fun(root1.right, root2.right);
    }
}