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
    boolean b= false ;
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();
        fun(root, k, hs);
        return b;
    }
     void fun (TreeNode root, int k, HashSet<Integer> hs) {
    if(root == null) return;
 
    if(hs.contains(k-root.val)) b = true;
    hs.add(root.val);
    fun(root.left, k, hs);
    fun(root.right, k, hs);
    }
}