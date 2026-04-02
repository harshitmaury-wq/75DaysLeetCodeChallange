/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return new String("[]");
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);
        sb.append('[');
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp != null ) sb.append(temp.val);
            else sb.append("null");
            sb.append(',');
            if(temp != null) { q.add(temp.left) ;}
           
            if(temp != null) {  q.add(temp.right); }
            
        }
        if(sb.charAt(sb.length()-1) == ',') sb.setLength(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1); // remove []

        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode root = new TreeNode (Integer.parseInt(arr[0])) ;
        q.add(root);
        int i = 1;
        while(i < arr.length && !q.isEmpty()){
            TreeNode t = q.remove();
            
            if(!arr[i].equals("null")) {
                t.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(t.left);
            }
            i++;
            if(i < arr.length && !arr[i].equals("null")) {
                t.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(t.right);
            }
            i++;
            
        }
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));