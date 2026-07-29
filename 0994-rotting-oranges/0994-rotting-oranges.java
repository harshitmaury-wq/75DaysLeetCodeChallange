class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        int[][] vis = new int[m][n] ;
        Queue<int[]> q = new LinkedList<>() ;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j< n; j++) {
                if(grid[i][j] == 2) 
                {q.add(new int[]{i, j}) ; vis[i][j] = 1 ;}
            }
        }
        int time = -1;
       
        while(!q.isEmpty()) {
            time++ ;
            int size = q.size() ;
            for(int i = 1; i<=size; i++) {
            int[] t = q.remove() ;
            int x = t[0] ;
            int y = t[1] ; 
            
            
            if(x + 1 < m && vis[x+1][y]==0 && grid[x+1][y]==1) {vis[x+1][y] = 1;q.add(new int[]{x+1, y}) ;}
            if(x - 1 >= 0 && vis[x-1][y]==0 && grid[x-1][y]==1) {vis[x-1][y] = 1;q.add(new int[]{x-1, y}) ;}
            if(y + 1 < n && vis[x][y+1]==0 && grid[x][y+1]==1) {vis[x][y+1] = 1;q.add(new int[]{x, y+1}) ;}
            if(y - 1 >= 0  && vis[x][y-1]==0 && grid[x][y-1]==1) {vis[x][y-1] = 1;q.add(new int[]{x, y-1}) ;}
            }
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j< n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1) return  -1 ;
            }
        }
        if(time == -1) return 0 ;
        return time ;
    }
}