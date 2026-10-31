class Solution {
    public int uniquePaths(int[][] grid) {
        // right  1
        // down  2

        int[][][] dp = new int[grid.length][grid[0].length][3] ;

        for(int i = 0; i<dp.length; i++) {
            for(int j = 0; j<dp[i].length; j++) {
                for(int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = -1 ;
                }
            }
        }
        return fun(grid, 0, 0, 0, dp) ;
    }
    int fun(int[][] g , int x, int y, int d, int[][][] dp) {
        if(x < 0 || y < 0 || x >= g.length || y >= g[0].length)
        return 0;

        if(x == g.length - 1 && y == g[0].length - 1 && g[x][y] == 0) return 1 ;

        if(dp[x][y][d] != -1) return dp[x][y][d] ;
        int sum = 0 ;
        if(g[x][y] == 1 && d == 1) {
            sum += fun(g, x+1, y, 2, dp) ;
        }
        else if(g[x][y] == 1 && d == 2) {
            sum += fun(g, x, y+1, 1, dp) ;
        }
        else {
            sum += fun(g, x+1, y, 2, dp) ;
            sum += fun(g, x, y+1, 1, dp) ;
        }

        return dp[x][y][d] = sum% 1000000007;
    } 
}