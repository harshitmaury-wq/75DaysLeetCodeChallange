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
    int max = Integer.MIN_VALUE;    
    public int maxPathSum(TreeNode root) {
        fun(root);
        return max;
    }
     int fun(TreeNode root){
        if(root==null) return 0; 

        int left = fun(root.left);
        int right = fun(root.right);
        int path = Math.max(root.val + Math.max(left, right), root.val);
         max = Math.max(max,Math.max(root.val+left+right, root.val));
         max = Math.max(Math.max(root.val+left, root.val+right), max);
         return path;


    }
}