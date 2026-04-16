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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

       
        List<List<Integer>> list = new ArrayList<>() ;
        if(root==null) return list;
        List<Integer> temp = new ArrayList<>();
        
        fun(root, targetSum, list, temp) ;
     
        return list ;
    }
    static void fun (TreeNode root, int t, List<List<Integer>> list, List<Integer> temp){

         if(root == null) return ;
        if(root.left==null && root.right == null && t-root.val==0){
            temp.add(root.val) ;
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return ;

        }
       
       

        temp.add(root.val);
        fun(root.left, t-root.val, list, temp) ;
        
        fun(root.right, t-root.val, list, temp) ;
        temp.remove(temp.size()-1) ;

    }
}