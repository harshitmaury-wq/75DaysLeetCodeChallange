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
    int max= Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        fun(root);
        return max;
    }
     int fun(TreeNode root){


        int left = 0;
        int right = 0;

        if(root.left != null)
        left = 1 + fun(root.left);

        if(root.right != null)
        right = 1 + fun(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}