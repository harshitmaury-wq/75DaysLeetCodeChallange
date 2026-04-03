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
    int preidx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int [] inorder = new int[preorder.length];
        for(int i=0; i<preorder.length; i++) inorder[i] = preorder[i];
        Arrays.sort(inorder);

        return build(inorder, preorder, 0, preorder.length-1) ;
     }
     TreeNode build(int[] in, int[] pre, int s, int e){
        if(s>e) return null;

        int nodeval = pre[preidx++];

        TreeNode node = new TreeNode(nodeval);
        int inidx = find(in, nodeval) ;

        node.left = build(in, pre, s, inidx-1);
        node.right = build(in, pre, inidx+1, e);

        return node;
     }
     int find(int[] in, int value){
        for(int i=0; i<in.length; i++) {
            if(in[i]==value) return i;
        }
        return -1;
     }
}       