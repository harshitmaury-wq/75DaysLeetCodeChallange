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
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();

        dq.addLast(root) ;

        while(!dq.isEmpty()){
            
        TreeNode temp = dq.removeFirst();

        if(!dq.isEmpty() && dq.peekLast()==null && temp!= null && temp.left!=null) return false ;
        else { if(temp!= null) dq.addLast(temp.left) ; }

        if(!dq.isEmpty() && dq.peekLast()==null && temp!= null && temp.right!=null) return false ;
        else{ if(temp!= null) dq.addLast(temp.right) ; }

      

        }
        return true;
    }
}