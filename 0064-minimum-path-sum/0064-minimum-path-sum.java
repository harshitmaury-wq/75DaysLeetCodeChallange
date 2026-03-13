class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return fun(grid, 0, 0, m, n, dp);
    }
    static int fun(int[][]arr, int r, int c, int m, int n, int[][] dp){

        if(r==m-1 && c==n-1) return arr[r][c];
        if(r>=m || c>=n) return 100000000;
        
        if(dp[r][c] != -1) return dp[r][c];
        
        int right = arr[r][c] + fun(arr, r, c+1, m, n, dp);
        int down =  arr[r][c] + fun(arr, r+1, c, m, n, dp);
        return dp[r][c] = Math.min(right,down);


    }
}