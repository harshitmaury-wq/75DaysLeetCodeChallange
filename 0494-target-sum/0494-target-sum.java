class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[2001][nums.length];

        for(int[] arr : dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return fun(nums, target, 0, 0, dp);
    }
    static int fun(int[] nums, int target, int sum, int s,int[][] dp){

        if(sum==target && s==nums.length) return 1;
        if(s==nums.length) return 0;

        if(dp[sum+1000][s] != Integer.MIN_VALUE) return dp[sum+1000][s] ;
        int plus = fun(nums, target, sum+nums[s], s+1, dp);
        int minus = fun(nums, target, sum-nums[s], s+1, dp);

        return dp[sum+1000][s] = plus+minus;

    }
}