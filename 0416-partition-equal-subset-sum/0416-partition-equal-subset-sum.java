class Solution {
    public boolean canPartition(int[] nums) {
        int S = 0;
    
        for(int i=0; i< nums.length; i++) S+=nums[i];
            if(S%2 != 0) return false;
            int[][] dp = new int[S+1][nums.length];
            for(int[] ele : dp) Arrays.fill(ele, -1);
        return fun(nums, 0, S/2, dp);
        
    }
    static boolean fun(int[] nums, int s, int sum, int[][] dp){
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(s==nums.length && s > 0) return false;

        if(dp[sum][s] != -1) return dp[sum][s] == 1;
        boolean b = fun(nums, s+1, sum-nums[s], dp) ||  fun(nums, s+1, sum, dp);

        if(b) dp[sum][s] = 1;
        else dp[sum][s] = 0;
       
        return b;

    }
}