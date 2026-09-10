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
    public int averageOfSubtree(TreeNode root) {
        int[] n = fun(root) ;
        return ans ;
    }
    int[] fun (TreeNode root) {
        if(root == null) return new int[]{0,0} ;


        int[] arr = new int[2] ;
        int[] left = fun(root.left) ;
        int[] right = fun(root.right) ;

        // number, left, right
        
        arr[0] = left[0] + right[0] + 1 ;
        int sum = left[1] + right[1] + root.val ;
        arr[1] = sum ;
        int avg = sum / arr[0] ;
        if(avg == root.val) ans ++ ;
        return arr;
    }
}