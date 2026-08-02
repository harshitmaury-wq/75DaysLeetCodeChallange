class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length][2][2*piles.length] ;
        for(int[][] ele: dp){
            for(int[] el : ele) Arrays.fill(el, -1) ;
        }
        return solveforalice(1, piles, 0, 1, dp) ;
    }
    int solveforalice (int p, int[] piles, int i, int M, int[][][] dp) {
        if(i >= piles.length) return 0 ;

        if(dp[i][p][M] != -1) return dp[i][p][M] ;
        int res = ( p == 1 ? -1 : Integer.MAX_VALUE ) ;
        int stones = 0;

        for(int x = 1; x<= 2*M && (i+x-1 < piles.length) ; x++) {
            

            if(p == 1) {
                stones += piles[i+x-1] ;
                res = Math.max(res, stones + solveforalice(0, piles, i+x, Math.max(M,x), dp)) ;
            }
            else {
                res = Math.min(res, solveforalice(1, piles,i+x, Math.max(M,x), dp)) ;
            }
        }
        return dp[i][p][M] = res ;
    }
}