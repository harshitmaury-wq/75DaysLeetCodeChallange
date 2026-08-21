class Solution {
    public int twoCitySchedCost(int[][] costs) {

        int n = costs.length/2 ;
        int[][][] dp = new int[costs.length+1][n+1][n+1] ;
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[i].length; j++)
                for(int k = 0; k<dp[i][j].length; k++) dp[i][j][k] = -1 ;
        }
        return fun(costs, 0, n, n, dp) ;
    }
    int fun(int[][] costs, int s, int ano, int bno, int[][][] dp) {
        if(s == costs.length || (ano == 0 && bno == 0)) return 0;
        if(ano == 0) {
            int sum = 0;
            for(int i = s; i<costs.length; i++) {
                sum+=costs[i][1] ;
            }
            return dp[s][ano][bno] = sum ;
        }
        if(bno == 0) {
            int sum = 0;
            for(int i = s; i<costs.length; i++) {
                sum+=costs[i][0] ;
            }
            return dp[s][ano][bno] = sum ;
        }

        if(dp[s][ano][bno] != -1) return dp[s][ano][bno] ;
        return dp[s][ano][bno] = Math.min(costs[s][0] + fun(costs, s+1, ano-1, bno, dp), costs[s][1] + fun(costs, s+1, ano, bno-1, dp)) ;
    }
}