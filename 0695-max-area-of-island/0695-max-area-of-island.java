class Solution {
    int[] r = {1, -1, 0, 0} ;
    int[] c = {0 , 0, 1, -1} ;
    int count = 0; 
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        int[][] vis = new int[m][n] ;
        int max = 0 ;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1 && vis[i][j]==0) {
                count = 0;
                 dfs(grid, i, j, vis) ;
                max = Math.max(count, max) ;
                }
            }
        }
        return max ;
    }
    void dfs(int[][] grid, int x, int y, int[][]vis) {
        if(x == grid.length || y == grid[0].length || x<0 || y<0 || vis[x][y] == 1|| grid[x][y] == 0) return ;

        count++;
        vis[x][y] = 1 ;
        for(int i = 0; i<4; i++) {
            dfs(grid, x+r[i], y+c[i], vis) ;
        }
        
    }
}