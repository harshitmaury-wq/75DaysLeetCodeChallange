class Solution {
    int[] dx = {1, -1, 0, 0} ;
    int[] dy = {0, 0, -1, 1} ;
    class Node{
        int r;
        int c;
        int k;
        int d;
        Node(int x, int y, int k, int d) {
            this.r = x ;
            this.c = y ;
            this.k = k ;
            this.d = d ;
        }

    }
    public int shortestPath(int[][] grid, int k) {
        
        int r = grid.length ;
        int c = grid[0].length ;
        if(r == 1 && c == 1) return 0 ;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {return a.d - b.d ;}) ;
        int[][][] distance = new int[r][c][k+1] ;

        for(int i = 0; i<distance.length; i++) {
            for(int j = 0; j<distance[i].length; j++){
                for(int z = 0; z<distance[i][j].length; z++) {
                    distance[i][j][z] = Integer.MAX_VALUE ;
                }
            }
        }

        pq.add(new Node(0,0,k,0)) ;

        while(!pq.isEmpty()) {

            Node t = pq.remove() ;
            int x = t.r ;
            int y = t.c ;
            int ck = t.k ;
            int dis = t.d ;

            

            for(int i = 0; i<4; i++) {
                int nx = x + dx[i] ;
                int ny = y + dy[i] ;

                if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    
                    if(grid[nx][ny] == 1 && ck > 0 && dis+1 < distance[nx][ny][ck-1] ){
                        distance[nx][ny][ck-1] = dis + 1 ;
                        pq.add(new Node(nx, ny, ck-1, dis + 1)) ;
                    }
                    else if(grid[nx][ny] == 0 && dis+1 < distance[nx][ny][ck] ) {
                        distance[nx][ny][ck] = dis + 1 ;
                        pq.add(new Node(nx, ny, ck, dis + 1)) ;
                    }
                    
                }
            }
        }

        int ans = Integer.MAX_VALUE ;

        for(int xy : distance[r-1][c-1]) ans = Math.min(ans, xy) ;

        return ans == Integer.MAX_VALUE ? -1 : ans ; 
    }
}