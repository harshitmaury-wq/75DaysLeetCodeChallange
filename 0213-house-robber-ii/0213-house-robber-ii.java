class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(fun(nums, 0, nums.length-2, dp1), fun(nums, 1, nums.length-1, dp2));

        
    }
    static int fun(int[] nums, int s, int e, int[] dp){
        if(e==s) return nums[s];
        if(e<s) return 0;

        if(dp[e] != -1) return dp[e];
        return dp[e] = Math.max(nums[e]+fun(nums, s, e-2, dp), fun(nums,s , e-1, dp));


    }
}