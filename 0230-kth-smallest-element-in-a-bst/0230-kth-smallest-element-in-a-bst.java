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
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1];
        arr[0] = k;
        fun(root, arr);
        return ans;
    }
     void fun(TreeNode root, int[] k){
        if(root == null) return ;

        fun(root.left, k);
        if(k[0]==1) ans = root.val;
        k[0]--;
        fun(root.right, k);
        

    }
}