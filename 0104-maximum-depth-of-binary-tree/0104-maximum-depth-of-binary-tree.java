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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        if(fun(root ) == Integer.MIN_VALUE) return 0;
        return fun(root);
    }
    static int fun (TreeNode root){
        if(root==null) return 0;

        int left =1 + fun(root.left);
        
       int right = 1 + fun (root.right);

        return Math.max(left, right);
    }
}