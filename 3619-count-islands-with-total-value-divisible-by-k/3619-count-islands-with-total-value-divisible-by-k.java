class Solution {
    int[] dx= {1, -1, 0, 0} ;
    int[] dy = {0, 0, 1 , -1} ;
    long sum = 0;
    public int countIslands(int[][] grid, int k) {
        int[][] vis = new int[grid.length][grid[0].length] ;
        int ans = 0;

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(vis[i][j] == 1 || grid[i][j] == 0) continue ;

                dfs(grid, vis, i, j) ;
                if(sum%k == 0) ans ++;
                sum = 0;
            }
        }
        return ans ;
    }
    void dfs(int[][] grid, int[][] vis, int x, int y) {

        sum += grid[x][y] ;
        vis[x][y] = 1 ;
        for(int i =0; i< 4; i++) {
            if(x+dx[i] < grid.length && y+dy[i] < grid[0].length && x+dx[i] >= 0 && y+dy[i] >= 0 && vis[x+dx[i]][y+dy[i]] == 0 && grid[x+dx[i]][y+dy[i]] != 0) {
                dfs(grid, vis, x+dx[i], y+dy[i]) ;
            }
        }
    }
}