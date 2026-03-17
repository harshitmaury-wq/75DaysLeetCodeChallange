class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return fun(amount, coins, 0, dp);
    }
    static int fun (int amt, int[]arr, int s, int[][] dp){
        if(amt == 0) return 1;
        if(amt<0) return 0;
        if(amt > 0 && s==arr.length) return 0; 


        if(dp[s][amt] != -1) return dp[s][amt];
        int take = fun(amt-arr[s] , arr, s, dp) ;
        int skip = fun(amt, arr, s+1, dp);

        return dp[s][amt] = take + skip;
    }
}