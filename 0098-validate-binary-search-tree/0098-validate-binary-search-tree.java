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
        List<Integer> list = new ArrayList<>();
        fun(root, list);
        if(list.size()==1) return true;
        for(int i=1; i<list.size(); i++){
            if(list.get(i)<=list.get(i-1)) return false ;
        }
        return true;
    }
    static void fun(TreeNode root, List<Integer>list){
        if(root==null) return ;

        fun(root.left, list);
        list.add(root.val);
        fun(root.right, list);
    }
}