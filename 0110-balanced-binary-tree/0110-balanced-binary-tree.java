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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(fun(root) == Integer.MAX_VALUE) return false;
        else return true;
    }
    static int fun (TreeNode root){


        
        int left = 0;
        int right = 0;
        if(root.left != null) {
        left =  fun(root.left);
        if(left != Integer.MAX_VALUE) left += 1; }

        if(root.right != null) {
        right =  fun(root.right);
        if(right != Integer.MAX_VALUE) right += 1; }

        if(Math.abs(left-right) >1) return Integer.MAX_VALUE;
        else return Math.max(left, right);
        
    }
}