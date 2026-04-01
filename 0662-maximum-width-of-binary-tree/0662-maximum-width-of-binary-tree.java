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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Deque<Long> index = new LinkedList<>();
        long max = 1;

        q.add(root);
        index.addFirst((long)0);

        while(!q.isEmpty()){
            int size = q.size();
           
            while(size != 0){
                 TreeNode temp = q.remove();
                 long idx = index.removeFirst();
                size--;
                if(temp.left != null) { q.add(temp.left); index.addLast((long)2*idx+1) ;}
                if(temp.right != null) { q.add(temp.right); index.addLast((long)2*idx+2) ;}
            }
            if(!index.isEmpty())
            max = Math.max(max, index.peekLast() - index.peekFirst() + 1) ;
            
        }

        return (int) max;
        
    }
}