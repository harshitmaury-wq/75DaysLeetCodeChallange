class Solution {
    int[] dx = {1, -1, 0, 0, -1, 1, -1, 1} ;
    int[] dy = {0, 0, 1, -1, -1, -1, 1, 1} ;
    public int maxDistance(int[][] grid) {
        int max = Integer.MIN_VALUE ;

        int[][] vis = new int[grid.length][grid[0].length] ;
        int[][] dis = new int[grid.length][grid[0].length] ;
        Queue<int[]> q = new LinkedList<>() ;

        for(int i = 0; i<grid.length;i++) {
            for(int j = 0; j<grid.length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i,j}) ;
                    vis[i][j] = 1;
                }
                dis[i][j] = Integer.MAX_VALUE ;
            }
        }
        while(!q.isEmpty()) {
            
            
            int[] temp = q.remove() ;
            int r = temp[0] ;
            int c = temp[1] ;
            Queue<int[]> qu = new LinkedList<>() ;
         for(int i = 0; i<8; i++) {
                int nx = r + dx[i] ;
                int ny = c + dy[i] ;

                if(nx < grid.length && nx >=0 && ny < grid.length && ny >= 0 && dis[nx][ny] > Math.abs(nx-r)+Math.abs(ny-c) && grid[nx][ny] == 0) {
                   
                     dis[nx][ny] = Math.abs(nx-r)+Math.abs(ny-c) ;
                    qu.add(new int[]{nx, ny}) ;
                }
            }
        
        
        
            while(!qu.isEmpty()){
                int[] t = qu.remove() ;
                int row = t[0] ;
                int col = t[1] ;

            for(int i = 0; i<8; i++) {
                int nrow = row + dx[i] ;
                int ncol = col + dy[i] ;

                if(nrow < grid.length && nrow >=0 && ncol < grid.length && ncol >= 0 && dis[nrow][ncol] > Math.abs(nrow-r)+Math.abs(ncol-c) && grid[nrow][ncol] == 0) {
                    dis[nrow][ncol] = Math.abs(nrow-r)+Math.abs(ncol-c) ;
                    
                    qu.add(new int[]{nrow, ncol}) ;
                }
            }
            
            
            }

        }

        for(int i = 0; i<grid.length;i++) {
            for(int j = 0; j<grid.length; j++) {
                if(grid[i][j] == 0) {
                    max = Math.max(max, dis[i][j]) ;
                }
            }
        }

        return max == Integer.MIN_VALUE || max == Integer.MAX_VALUE ? -1: max ;
    }
       
}