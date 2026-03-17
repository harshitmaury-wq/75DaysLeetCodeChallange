class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][1001];

        for(int[] arr : dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return fun(nums, target, 0, 0, dp);
    }
    static int fun(int[] nums, int target, int sum, int s,int[][] dp){

        if(sum==target && s==nums.length) return 1;
        if(s==nums.length) return 0;

        
        int plus = fun(nums, target, sum+nums[s], s+1, dp);
        int minus = fun(nums, target, sum-nums[s], s+1, dp);

        return  plus+minus;

    }
}