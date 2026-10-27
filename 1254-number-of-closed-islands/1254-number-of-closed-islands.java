class Solution {
    int[] dx = {1, -1, 0, 0} ;
    int[] dy = {0 , 0, 1, -1} ;
    public int closedIsland(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length] ;
        int ans = 0;

        for(int i =0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length;j++) {
                if(vis[i][j] == 1 || grid[i][j] == 1) continue ;

                if(isclose(vis, grid, i, j)) ans++;
            }
        }
        return ans ;
    }
    boolean isclose (int[][] vis, int[][] grid, int x, int y) {
        if(x == grid.length-1 || y == grid[0].length-1 || x == 0 || y == 0 ) return false ;

        boolean b = true ;
        for(int i = 0; i<4; i++) {
            if(x+dx[i] >= 0 && x+dx[i] < grid.length && y+dy[i] >=0 && y+dy[i] < grid[0].length && vis[x+dx[i]][y+dy[i]] == 0 && grid[x+dx[i]][y+dy[i]] == 0){
                vis[x+dx[i]][y+dy[i]] = 1;
                b &= isclose(vis, grid, x+dx[i], y+dy[i]) ;
            }
        }
        return b ;
    }
}