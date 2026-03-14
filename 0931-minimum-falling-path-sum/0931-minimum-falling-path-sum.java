class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) min = Math.min(min, fun(matrix, 0, i, dp, n));
        return min;
        
    }
    static int fun(int[][] arr, int r, int c, int[][] dp, int n){
        if( c>=n || c<0 ) return 30000000;
        if(r==n-1) return arr[r][c];
        
        

        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c]; 
        int below = arr[r][c]+ fun(arr, r+1, c, dp, n);
        int lbelow = arr[r][c]+ fun(arr, r+1, c-1, dp, n);
        int rbelow = arr[r][c]+ fun(arr, r+1, c+1, dp, n);

        return dp[r][c] = Math.min(below, Math.min(lbelow, rbelow));
        
    }
}