class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        int[][] vis = new int[m][n] ;

        int c = 0; 
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    c++;
                    dfs(grid, i, j, vis) ;
                }
            }
        }

        return c ;
    }
    void dfs (char[][] grid, int x, int y, int[][] vis) {
        if(x == grid.length || x < 0 || y==grid[0].length || y<0 || vis[x][y] == 1 || grid[x][y] == '0') return ;

        vis[x][y] = 1;
        
        dfs(grid, x+1, y, vis) ;
        dfs(grid, x-1, y, vis) ;
        dfs(grid, x, y+1, vis) ;
        dfs(grid, x, y-1, vis) ;

    }
}