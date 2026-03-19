class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(prices, 0, 1, 0, dp);
    }
    static int fun(int[] arr, int i, int b, int n, int[][][] dp){
        if(n>=2 || i==arr.length || n<0) return 0;

        if(dp[i][b][n] != -1) return dp[i][b][n];
        if(b==1){
         int buy = -1*arr[i] + fun(arr, i+1, 0, n, dp);
         int notbuy = fun(arr, i+1, 1, n, dp);
         return dp[i][b][n] = Math.max(buy, notbuy);
        }
        else{
            int sell = arr[i] + fun(arr, i+1, 1, n+1, dp);
            int notsell = fun(arr, i+1, 0, n, dp);
              return dp[i][b][n] = Math.max(sell, notsell);
        }
    }
}