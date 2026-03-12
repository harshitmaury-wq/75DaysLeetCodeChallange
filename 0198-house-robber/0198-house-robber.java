class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return fun(nums, nums.length-1, dp);
    }
    static int fun(int[] nums, int e , int[]dp ){
        if(e==0 ) return nums[0];
        if(e<0) return 0;

        if(dp[e] != -1) return dp[e];
        return dp[e] = Math.max(nums[e]+fun(nums, e-2, dp), fun(nums, e-1, dp) );
    }
}