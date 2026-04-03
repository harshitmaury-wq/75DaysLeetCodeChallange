/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return fun(root, p, q) ;
    }
    static TreeNode fun (TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

        if(root.val > p.val && root.val > q.val) return fun(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return fun(root.right, p, q);
        if(root.val >= p.val && root.val <= q.val) return root;
        if(root.val <= p.val && root.val >= q.val) return root;
        else return null;
    }
}