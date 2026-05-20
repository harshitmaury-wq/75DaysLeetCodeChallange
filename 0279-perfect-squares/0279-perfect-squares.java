class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1] ;
        Arrays.fill(dp, -1) ;
        
        return fun(n, dp) ;
    }
    int fun (int n, int[] dp) {
        if(n == 0) return 0;
        if(n < 0) return 100000 ; 

        if(dp[n] != -1) return dp[n] ;
        int steps = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            steps = Math.min(steps, 1 + fun(n - i*i, dp) );
        }
        return dp[n] = steps;
    }
}