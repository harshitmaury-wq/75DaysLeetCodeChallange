class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
       
       
        for(int i=0; i<nums.length; i++){
            int take = nums[i] ;
            if(i-2 >= 0) take += dp[i-2];
            int skip = 0;
            if(i-1>=0) skip += dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        return dp[nums.length-1];
    }
}