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
    TreeNode target;
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> hs = new HashSet<>();
        int time = -1;
        findparent(root, hm, start);


        q.add(target);
        hs.add(target);

        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                TreeNode temp = q.remove();
                size--;
                if(!hs.contains(temp.left) && temp.left != null) { q.add(temp.left); hs.add(temp.left) ; }
                if(!hs.contains(temp.right) && temp.right != null) { q.add(temp.right); hs.add(temp.right) ; }
                if(hm.containsKey(temp) && !hs.contains(hm.get(temp))) { q.add(hm.get(temp)); hs.add(hm.get(temp)) ;}
            }
            time++;
        }
        return time;
    }
     void findparent(TreeNode root, HashMap<TreeNode, TreeNode > hm, int start){
        if(root == null) return ;

        if(root.left != null) hm.put(root.left, root);
        findparent(root.left, hm, start);
        if(root.val == start) target = root;
        if(root.right != null) hm.put(root.right, root);
        findparent(root.right, hm, start);
    }
    
}