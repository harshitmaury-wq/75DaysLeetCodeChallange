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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root==null) return list;

        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                TreeNode t = q.remove();
                temp.add(t.val);
                size--;
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            if(flag) {
                Collections.reverse(temp);
                list.add(new ArrayList<>(temp));
                flag = false;
            }
            else {
            list.add(new ArrayList<>(temp));
            flag = true;
            }
            temp.clear();
        }

        return list;
    }
}