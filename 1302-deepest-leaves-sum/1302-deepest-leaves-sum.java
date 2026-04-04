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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int sum = 0;
        while(!q.isEmpty()){
            int size= q.size();
            sum = 0;
            while(size != 0){
                TreeNode t = q.remove();
                size--;
                sum+=t.val;
            if(t.left != null) q.add(t.left);
            if(t.right != null) q.add(t.right);
            }
            

        }
        return sum;
    }
}