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
    public boolean isValidBST(TreeNode root) {
        return fun (root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static boolean fun(TreeNode root, long l, long r){
        if(root == null) return true;

        if(root.val > l && root.val < r) return fun(root.left, l, root.val) && fun(root.right, root.val, r);
        else return false;
    }
}