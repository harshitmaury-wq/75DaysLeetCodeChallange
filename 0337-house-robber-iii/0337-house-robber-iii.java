class Solution {
    public int rob(TreeNode root) {
        int[] ans = fun(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] fun(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = fun(root.left);
        int[] right = fun(root.right);

        // Don't rob current node
        int notTake = Math.max(left[0], left[1])
                    + Math.max(right[0], right[1]);

        // Rob current node
        int take = root.val + left[0] + right[0];

        return new int[]{notTake, take};
    }
}