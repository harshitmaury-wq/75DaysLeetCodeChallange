class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length ;

        int[][] vis = new int[m][n] ;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) 
                return fun(grid, vis, m, n, i, j) ;
            }
        }
        return -1 ;
    }

    int fun(int[][] grid, int[][] vis, int m, int n, int r, int c) {
        if(r<0 || c<0 || r>=m || c>= n || vis[r][c] == 1 || grid[r][c] == -1) return 0;
        if(grid[r][c] == 2) {
            vis[r][c] = 1 ;
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++) {
                    if(vis[i][j] == 0 && grid[i][j] != -1){
                    vis[r][c] = 0 ;
                    return 0;
                    }
                }
            }
            vis[r][c] = 0;
            return 1 ;
        }

        vis[r][c] = 1 ;
        int up = fun(grid, vis,m ,n, r-1, c) ;
        int down = fun(grid, vis,m , n, r+1, c) ;
        int left = fun(grid, vis, m, n, r, c-1) ;
        int right = fun(grid, vis, m, n, r, c+1) ;

        vis[r][c] = 0;

        return up + down + left + right ;

    }
}