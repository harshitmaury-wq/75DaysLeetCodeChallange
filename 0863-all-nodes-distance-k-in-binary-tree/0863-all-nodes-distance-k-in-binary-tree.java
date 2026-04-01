/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        HashSet<TreeNode> hs = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        findparent(root, hm);
        
        q.add(target);
        hs.add(target);

        while(k != 0){
            int size = q.size();
            while(size != 0){
                TreeNode temp = q.remove();
                size--;
                if(!hs.contains(temp.left) && temp.left != null) { q.add(temp.left); hs.add(temp.left) ; }
                if(!hs.contains(temp.right) && temp.right != null) { q.add(temp.right); hs.add(temp.right) ; }
                if(hm.containsKey(temp) && !hs.contains(hm.get(temp))) { q.add(hm.get(temp)); hs.add(hm.get(temp)) ;}
            }
            k--;
        }
        while(!q.isEmpty() ) list.add(q.remove().val);
        return list;
    }
    static void findparent (TreeNode root, HashMap<TreeNode, TreeNode> hm){
        if(root == null) return ;

        if(root.left != null) hm.put(root.left, root);
        findparent(root.left, hm);
        if(root.right != null) hm.put(root.right, root);
        findparent(root.right, hm);

    }
}