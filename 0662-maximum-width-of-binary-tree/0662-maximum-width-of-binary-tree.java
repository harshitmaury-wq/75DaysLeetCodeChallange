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
        Deque<TreeNode> d = new LinkedList<>();
        Deque<Long> index = new LinkedList<>();
        long max = 1;

        d.addFirst(root);
        index.addFirst((long)0);

        while(!d.isEmpty()){
            int size = d.size();
           
            while(size != 0){
                 TreeNode temp = d.removeFirst();
                 long idx = index.removeFirst();
                size--;
                if(temp.left != null) { d.addLast(temp.left); index.addLast((long)2*idx+1) ;}
                if(temp.right != null) { d.addLast(temp.right); index.addLast((long)2*idx+2) ;}
            }
            if(!index.isEmpty())
            max = Math.max(max, index.peekLast() - index.peekFirst() + 1) ;
            
        }

        return (int) max;
        
    }
}