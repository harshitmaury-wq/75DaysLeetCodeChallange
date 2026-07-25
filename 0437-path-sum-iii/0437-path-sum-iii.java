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
    HashMap<Long, Integer> hm = new HashMap<>() ;
    
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        hm.put((long)0, 1) ;

        fun(root, targetSum, 0) ;
        return ans ;
    }
    void fun(TreeNode root, int ts , long cs) {
        if(root == null) return ;


        cs+=root.val;
        if(hm.containsKey(cs - ts)) ans += hm.get(cs-ts) ;
        if(hm.containsKey(cs)) hm.put(cs, hm.get(cs) + 1) ;
        else hm.put(cs, 1) ;

        fun(root.left, ts, cs) ;
        fun(root.right, ts, cs) ;

        hm.put(cs, hm.get(cs) - 1 ) ;
        if(hm.get(cs) == 0) hm.remove(cs) ;

    }
}