class Solution {
    public boolean hasValidPath(char[][] grid) {
        int[][][] dp = new int[101][101][1001] ;
        for(int i = 0; i<dp.length; i++) {
            for(int j = 0; j<dp[i].length; j++) {
                for(int k = 0; k<dp[i][j].length; k++) {
                    dp[i][j][k] = -1 ;
                }
            }
        }
        return fun(grid, 0,0, 0, dp) ;
    }
    boolean fun (char[][] g, int x , int y, int c, int[][][] dp) {
        if(c < 0 || x >= g.length || y >= g[0].length ) return false ;
        if(x == g.length-1 && y == g[0].length-1 ) {
            if(g[x][y] == ')' && c == 1) return true ;
            return false ;
        }
        
        if(dp[x][y][c] != -1) return dp[x][y][c] == 1 ;
        boolean b ;
        if(g[x][y] == ')') {
            b= fun(g, x+1, y, c-1, dp) || fun(g, x, y+1, c-1, dp) ;
            if(b) {
                 dp[x][y][c] = 1 ; return true;
                
            }
            else { dp[x][y][c] = 0 ; return false ; }
        }
        else {
            b = fun(g, x+1, y, c+1, dp) || fun(g, x, y+1, c+1, dp) ;
             if(b) {
                 dp[x][y][c] = 1 ; return true;
                
            }
            else { dp[x][y][c] = 0 ; return false ; }
        }
    }
}