class Solution {
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0} } ;
    public int swimInWater(int[][] grid) {
        int n = grid.length ;

        int s = 0;
        int e = n*n -1 ;
        int ans = -1 ;
        while(s<=e) {
            int mid = s + (e - s) /2 ;
            
            int vis[][] = new int[n][n] ;
            if(dfs(grid, vis, mid , 0,0)) {ans= mid; e = mid - 1 ;}
            else s = mid + 1;
            
        }

        return ans ;
        
    }
    boolean dfs (int[][] grid, int[][] vis, int t, int x , int y) {
        if( x>=grid.length || x<0 || y>=grid[0].length || y<0 || vis[x][y] == 1 || grid[x][y] > t ) return false;
        if(x == grid.length - 1 && y == grid[0].length - 1) return true ;

        vis[x][y] = 1;
        for(int i = 0; i<4; i++) {
            int newx = x + dir[i][0] ;
            int newy = y+ dir[i][1] ;

            if(dfs(grid, vis, t, newx, newy)) return true ; 
        }

        return false ;
        
    }
}