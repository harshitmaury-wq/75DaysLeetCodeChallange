class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return fun(0,0,m,n, dp);
        
    }
    static int fun (int r, int c, Integer m, Integer n, int[][] dp){
        if(r==m-1 && c==n-1) return 1;
        if(r>=m || c>=n) return 0;

        if(dp[r][c] != -1) return dp[r][c];
       return dp[r][c] = fun(r, c+1,m,n, dp) + fun(r+1, c,m,n,dp);
        
    }
}