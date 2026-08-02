class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;
        int sum = 0;
        for(int i : piles) sum += i ;

        int alice = fun(piles, 0, piles.length-1 , dp) ;
        return alice > (sum-alice) ;
        
    }
    int fun (int[] piles, int i, int j, int[][] dp) {
        if(j == i+1) return Math.max(piles[i], piles[j]) ;

        if(dp[i][j] != -1) return dp[i][j] ;
        int take_i = piles[i] + Math.min(fun(piles, i+2, j, dp), fun(piles, i+1, j-1, dp)) ;
        int take_j = piles[j] + Math.min(fun(piles, i, j-2, dp), fun(piles, i+1, j-1,dp)) ;

        return dp[i][j] = Math.max(take_i, take_j) ;
    }
}