class Solution {
    public long maxTotal(int[] nums, String s) {
        long[][] dp = new long[s.length()+1][2] ;
        for(long[] ele : dp) Arrays.fill(ele, -1) ;

        long sum = nums[0];
        if(s.charAt(0) == '0') return  fun(nums, s, 1, 0, dp) ;
        else return sum + fun(nums, s, 1, 1, dp) ;
    }
    long fun(int[]nums, String s, int st, int u, long[][] dp){
          if(st==nums.length) return 0;
        if(s.charAt(st)=='0') return fun(nums, s, st+1, 0, dp) ;
      

        if(dp[st][u] != -1) return dp[st][u] ;
        long take = 0, back = Long.MIN_VALUE;
        
          

            take = nums[st] + fun(nums, s, st+1, 1, dp) ;

            
            if(u == 0) 
            back = nums[st-1] + fun(nums, s, st+1, 0, dp);
        

        return dp[st][u] = Math.max(take , back) ;
    }
}