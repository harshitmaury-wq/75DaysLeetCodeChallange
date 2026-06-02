class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
       return Math.min(fun(cost, 0, dp), fun(cost, 1, dp));
    }
    static int fun (int[] arr, int s, int[] dp){
    
        if(s>=arr.length) return 0;        
        if(dp[s] != -1 ) return dp[s];
        int left = fun(arr, s+1, dp) + arr[s];
        
        
         int right = fun(arr, s+2, dp) + arr[s];

        return  dp[s] = Math.min(left, right);
    }
    
}