class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[][][] dp = new int[items.length+1][budget+1][2] ;
        for(int[][] ele : dp){
            for(int[] e : ele) Arrays.fill(e, -1) ;
        }
        int[] gain = new int[items.length] ;
        for(int i=0; i<gain.length; i++){
            gain[i] = 1;
            for(int j=0; j<gain.length; j++){
                if(i!=j && items[j][0]%items[i][0] == 0) gain[i]++;
            }
        }

        return fun(items, budget, gain, 0, 0, dp) ;
    }
    int fun(int[][] items, int b, int[] gain, int s, int t, int[][][]dp){
        if(s==gain.length) return 0;
        if(b<0) return Integer.MIN_VALUE;

        if(dp[s][b][t] != -1) return dp[s][b][t] ;
        if(t == 0){
            int firsttake = gain[s] + fun(items, b-items[s][1],gain, s, 1,dp) ;
            int skip = fun(items, b, gain, s+1, 0, dp) ;
            return dp[s][b][t] = Math.max(firsttake, skip) ;
        }

        else {
            int takemore = 1 + fun(items, b-items[s][1],gain, s, 1, dp) ;
            int skip = fun(items, b,gain, s+1, 0, dp) ;
            return dp[s][b][t] = Math.max(takemore, skip) ;
        }

    }
}