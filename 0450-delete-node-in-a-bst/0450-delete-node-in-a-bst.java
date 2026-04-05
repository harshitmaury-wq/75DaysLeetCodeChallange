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
    public TreeNode deleteNode(TreeNode root, int key) {
       return delete(root, key) ;
    }
      static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } 
        else if (key > root.val) {
            root.right = delete(root.right, key);
        } 
        else {
            // found node

            // case 1: leaf
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 3: two children
            int max = getMax(root.left);
            root.val = max;

            // delete that max node from left subtree
            root.left = delete(root.left, max);
        }

        return root;
    }

    static int getMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
