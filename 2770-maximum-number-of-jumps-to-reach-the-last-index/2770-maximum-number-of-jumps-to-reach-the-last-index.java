class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[][] dp = new int[nums.length][nums.length] ;

        for(int[] ele : dp) Arrays.fill(ele, -1) ;



        int jumps = fun(nums, target, 1, 0, dp) ;
        if(jumps == Integer.MAX_VALUE) return -1 ;

        return jumps+1;
    }

    int fun (int[] nums, int t, int s, int last, int[][] dp) {
        if(s == nums.length-1 && Math.abs(nums[s]-nums[last]) <= t ) return 0;

        if(s == nums.length-1 && Math.abs(nums[s]-nums[last]) > t ) return Integer.MAX_VALUE ;
        

        if(dp[s][last] != -1) return dp[s][last] ;
        if(Math.abs(nums[s] - nums[last]) <= t) {
            int take  = fun(nums, t, s+1, s, dp) ;
            if(take != Integer.MAX_VALUE ) take++ ;
            int skip = fun(nums, t, s+1, last, dp) ;

            if(take == Integer.MAX_VALUE && skip != Integer.MAX_VALUE) return  dp[s][last] =skip ;
            else if(take != Integer.MAX_VALUE && skip == Integer.MAX_VALUE) return dp[s][last]= take ;
            else return dp[s][last] = Math.max(skip, take) ;
        }

        else return dp[s][last]= fun(nums, t, s+1, last, dp) ;
    }
}