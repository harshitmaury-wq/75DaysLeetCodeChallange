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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return fun(root, targetSum) ;
    }
    static boolean fun (TreeNode root, int t){
        if(root==null) return false ;
        if(root.left == null && root.right == null){
            if(t-root.val == 0) return true;
            return false ;
        }
       

        boolean b1 = fun(root.left, t-root.val) ;
        boolean b2 = fun(root.right, t-root.val) ;

        return b1||b2;
    }
}