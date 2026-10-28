class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m+1][n+1][2000];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                for(int k=0; k<2000; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
      
        return fun(grid, 0, 0, m, n,0, dp);
    }
    static int fun (int[][] arr, int r, int c, int m , int n, int x, int[][][]dp){
        if(r==m-1 && c==n-1) return x^arr[r][c];
        if(r>=m || c>=n) return Integer.MAX_VALUE;

        if(dp[r][c][x] != -1) return dp[r][c][x];
        int right =  fun(arr, r, c+1, m, n,arr[r][c] ^x, dp);
        
        int down =  fun(arr, r+1, c, m, n,arr[r][c] ^x, dp);

        return dp[r][c][x] = Math.min(right, down);
    }
}