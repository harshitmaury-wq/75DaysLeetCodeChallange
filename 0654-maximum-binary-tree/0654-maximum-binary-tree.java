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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return fun(nums, 0, nums.length - 1) ;
    }

    static TreeNode fun (int[] nums, int s, int e) {
        if(s > e) return null ;

        int max = s;
        for(int i = s; i<= e; i++) {
            if(nums[i] > nums[max] ) max = i ;
        }

        TreeNode root = new TreeNode(nums[max], fun(nums, s, max - 1), fun(nums, max+1, e)) ;

       


        return root; 
        
    }
}