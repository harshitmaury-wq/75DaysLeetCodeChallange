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
    
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
     
        fun(root, list, sb);
        return list;
        
    }
     void fun (TreeNode root, List<String>list, StringBuilder temp){
     
        if(root==null) {return; }
        if(root.left==null && root.right == null){
            temp.append(root.val);
            list.add(temp.toString());
            return ;
        }

       
        temp.append(root.val);
        temp.append("->");
         int s = temp.length();
        fun(root.left, list, temp);
        temp.setLength(s);
        fun(root.right, list, temp);
        temp.setLength(s);
    }
}