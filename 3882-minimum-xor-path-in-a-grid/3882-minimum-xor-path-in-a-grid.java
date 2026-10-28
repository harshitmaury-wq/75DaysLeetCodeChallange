class Solution {
    public int minCost(int[][] grid) {

        int m = grid.length ;
        int n = grid[0].length ;

        int[][][] dp = new int[m][n][1024] ;

        for(int i = 0; i<dp.length; i++) {
            for(int j = 0 ; j<dp[i].length; j++) {
                for(int k = 0; k<dp[i][j].length; k++) {
                    dp[i][j][k] = -1 ;
                }
            }
        }

        return fun(grid, 0, 0, 0, m, n, dp) ;
    }

    // kyuki ye xor h, ham ise plus minus ki tarah nhi treat kar sakte means it is not necessary that min xor min = min, it may increase one of those that's why we are tking a seperate variable val 

    int fun (int[][] grid, int x, int y, int val, int m, int n, int[][][]dp) {
        if(x == m-1 && y == n-1 ) return dp[x][y][val] = val ^ grid[x][y] ;
        if(x == m || y == n ) return Integer.MAX_VALUE ;

        if(dp[x][y][val] != -1) return dp[x][y][val] ;
        int right = fun(grid, x, y+1, val^grid[x][y], m, n, dp) ;
        int down = fun(grid, x+1, y, val^grid[x][y], m, n, dp) ;

        return dp[x][y][val] = Math.min(right, down) ;
    }
}