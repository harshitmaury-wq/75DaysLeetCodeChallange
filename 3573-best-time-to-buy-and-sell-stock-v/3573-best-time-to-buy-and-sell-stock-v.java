class Solution {
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length][k+1][3] ;
        for(int i = 0; i<dp.length; i++) {
            for(int j = 0; j<dp[i].length; j++) {
                for(int x = 0; x<dp[i][j].length; x++){
                    dp[i][j][x] = -1 ;
                }
            }
        }

        return fun(prices, 0, k, 0, dp) ;
    }
    long fun (int[] p, int s, int k, int l, long[][][]dp) {
        if(s == p.length && l != 0) return Long.MIN_VALUE ;
        if(s == p.length || k == 0) return 0;           

        if(dp[s][k][l] != -1) return dp[s][k][l];
        if(l==0 ){
        long buy =   fun(p, s+1, k, 1, dp) ;
        if(buy != Long.MIN_VALUE) buy += -1*p[s] ;

        long sell = fun(p, s+1, k, 2, dp) ;
        if(sell != Long.MIN_VALUE) sell += p[s] ;

        long skip = fun(p, s+1, k, 0, dp) ;

        return dp[s][k][l] = Math.max(skip, Math.max(buy, sell)) ;
        }

        else {
            if(l == 2) return dp[s][k][l] = Math.max(-1*p[s] + fun(p, s+1, k-1, 0, dp), fun(p, s+1, k, l, dp)) ;
            else return dp[s][k][l] = Math.max(p[s] + fun(p, s+1, k-1, 0, dp), fun(p, s+1, k, l, dp)) ;
        }
    }
}