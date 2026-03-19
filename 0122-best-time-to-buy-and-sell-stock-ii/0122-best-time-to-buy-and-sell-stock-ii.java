class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] ele: dp) Arrays.fill(ele, -1);
        return fun(prices, 0, 1, dp);
    }
    static int fun (int[] arr, int i, int b, int[][] dp){
        if(i==arr.length) return 0;


        if(dp[i][b] != -1) return dp[i][b];
        if(b==1){
            int buy = -1*arr[i] + fun(arr,i+1,0, dp);
            int notbuy = fun(arr, i+1, 1, dp);
               return dp[i][b] = Math.max(buy, notbuy);
        }
        else{
            int sell = arr[i] + fun(arr, i+1, 1, dp);
            int notsell = fun(arr, i+1, 0, dp);
            return dp[i][b] = Math.max(sell, notsell);
        }

    }
}