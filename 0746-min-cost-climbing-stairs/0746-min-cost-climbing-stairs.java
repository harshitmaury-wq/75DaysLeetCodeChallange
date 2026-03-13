class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
       return fun(cost, cost.length, dp);
    }
    static int fun (int[] arr, int e, int[] dp){
    
        if(e<=0) return 0;
        


        if(dp[e] != -1 ) return dp[e];
        int left = fun(arr, e-1, dp) + arr[e-1];
        
        int right = 0;
        if(e>1)
         right = fun(arr, e-2, dp) + arr[e-2];

        return dp[e] = Math.min(left, right);
    }
    
}