class Solution {
    public long maxScore(int[] nums, int x) {
        long[][] dp = new long[nums.length][3] ;
        for(long[] ele : dp) Arrays.fill(ele, -1) ;

        return fun(nums, 0, -1, x, dp) ;
    }
    long fun(int[] nums, int i, int p, int x, long[][] dp) {

        if(i == nums.length) return  0; 

        if(dp[i][p+1] != -1) return dp[i][p+1] ;
         if(p == -1 || nums[i]%2 == p) {
            long take = nums[i]+fun(nums, i+1, nums[i] % 2 == 0 ? 0 : 1, x,dp) ;
            return dp[i][p+1] = take ;

        }
        else {
            long take = nums[i] - x + fun(nums, i+1, nums[i] % 2 == 0 ? 0 : 1,x, dp) ;
            long skip = fun(nums, i+1, p,x, dp) ;

            return dp[i][p+1]=Math.max(take, skip) ;

        }

    }
}