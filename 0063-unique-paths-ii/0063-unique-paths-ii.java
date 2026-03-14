class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return fun(obstacleGrid, m, n, 0, 0, dp);
        
    }
    static int fun(int[][] arr, int m, int n, int r, int c,int[][] dp){
         if(r>=m || c>=n || arr[r][c]==1) return 0;
        if(r==m-1 && c==n-1) return 1;
       

        if(dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = fun(arr, m, n, r, c+1, dp) + fun(arr, m, n, r+1, c, dp);
        
    }
}