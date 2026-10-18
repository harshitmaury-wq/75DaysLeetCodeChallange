class Solution {
    int x = -1;
    int y = -1 ;
    public int[] lastVisitedCell(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length] ;

       
        fun(grid, vis, 0, 0, 0, 0) ;
        return new int[]{x, y} ;
    }
    void fun(char[][] grid, int[][] vis, int cx, int cy, int px, int py) {
        if(cx < 0 || cy < 0 || cx == grid.length || cy == grid[0].length || vis[cx][cy]==1 ) {
            x = px;
            y = py ;
            return ;
        }

        vis[cx][cy] = 1 ;
        char c = grid[cx][cy] ;
        
        if(c == 'U') fun(grid, vis, cx-1, cy, cx, cy) ;
        else if(c == 'D') fun(grid, vis, cx+1, cy, cx, cy) ;
        else if(c == 'R') fun(grid, vis, cx, cy+1, cx, cy) ;
        else fun(grid, vis, cx, cy-1, cx, cy) ;
    }
}