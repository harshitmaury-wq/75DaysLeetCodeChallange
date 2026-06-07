class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ans = fun(coins, 0, amount, dp);

        if(ans ==  Integer.MAX_VALUE) return -1;
        else return ans;
    }
    static int fun (int[] arr, int s, int amt ,int dp[][]){
        if(amt == 0) return 0;
        if(amt < 0 ) return Integer.MAX_VALUE;
        if(s==arr.length) return Integer.MAX_VALUE;

        if(dp[s][amt] != -1) return dp[s][amt];
        int take = fun(arr, s, amt - arr[s], dp);
        if(take != Integer.MAX_VALUE) take+=1;
        int skip = fun(arr, s+1, amt, dp);

        return dp[s][amt] = Math.min(take, skip);
    }
}