class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<2; j++){
                for(int l=0; l<k+1; l++){
                    dp[i][j][l] = -1;
                }
            }
        }
        return fun(k, prices, 0, 1, dp);
    }
    static int fun (int k, int[] arr, int i, int b, int[][][]dp){
        if(k==0 || i==arr.length) return 0;

        if(dp[i][b][k] != -1) return dp[i][b][k];
        if(b==1){
            int buy = -1*arr[i] + fun(k, arr, i+1, 0, dp);
            int notbuy = fun(k , arr, i+1, 1,dp);
            return dp[i][b][k] = Math.max(buy, notbuy);
        }
        else {
            int sell = arr[i] + fun(k-1, arr, i+1, 1, dp);
            int notsell = fun(k, arr, i+1, 0, dp);
            return dp[i][b][k] =  Math.max(sell, notsell);
        }
    }
}