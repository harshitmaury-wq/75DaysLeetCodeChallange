class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length; 
        int n = isWater[0].length ;

        int[][] h = new int[m][n] ;

        Queue<int[]> q = new LinkedList<>() ;
        int[][] vis = new int[m][n] ;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(isWater[i][j] == 1) {q.add(new int[]{i,j}) ; vis[i][j] = 1;}

            }
        }

        while(!q.isEmpty()) {
            int[] t = q.remove() ;
            int x = t[0] ;
            int y = t[1] ;

            if(x+1 < m && vis[x+1][y]==0 ) {vis[x+1][y] =1; h[x+1][y] = h[x][y]+1 ; q.add(new int[]{x+1, y}) ;}
            if(x-1 >= 0 && vis[x-1][y]==0 ) {vis[x-1][y] =1; h[x-1][y] = h[x][y]+1 ;q.add(new int[]{x-1, y}) ;}
            if(y+1 < n && vis[x][y+1]==0 ) {vis[x][y+1] =1; h[x][y+1] = h[x][y]+1 ;q.add(new int[]{x, y+1}) ;}
            if(y-1 >= 0 && vis[x][y-1]==0 ) {vis[x][y-1] =1; h[x][y-1] = h[x][y]+1 ;q.add(new int[]{x, y-1}) ;}
        }
        return h ;
    }

}