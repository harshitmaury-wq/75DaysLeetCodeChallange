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
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if(root == null) return list;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while(size != 0){
                TreeNode t = q.remove();
                temp.add(t.val);
                size--;
                if( t.left != null) q.add(t.left);
                if( t.right != null) q.add(t.right);
            }
            list.add(new ArrayList<>(temp));
            temp.clear();
        }
        return list;
    }
}