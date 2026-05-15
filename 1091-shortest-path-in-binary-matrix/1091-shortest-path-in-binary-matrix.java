class Solution {
    class Node{
        int x;
        int y;
        int d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d ;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        Queue<Node> q = new LinkedList<>() ;
        int n = grid.length;
        int[][] vis = new int[n][n] ;
        for(int i=0; i<vis.length; i++){
            for(int j=0; j<grid[i].length; j++){
                vis[i][j] = -1 ;
            }
        }

        q.add(new Node(0,0,1));
        vis[0][0]  = 1;

        while(!q.isEmpty()){
            Node temp = q.remove() ;
            int x = temp.x;
            int y = temp.y;
            int d = temp.d;

            if(x+1<n && vis[x+1][y] == -1 &&  grid[x+1][y]==0){
                vis[x+1][y] = d+1;
                q.add(new Node(x+1, y, d+1)) ;
            } 
              if(y+1<n && vis[x][y+1] == -1 && grid[x][y+1]==0){
                vis[x][y+1] = d+1;
                q.add(new Node(x, y+1, d+1)) ;
            } 
              if(x-1>=0 && vis[x-1][y] == -1 && grid[x-1][y]==0){
                vis[x-1][y] = d+1;
                q.add(new Node(x-1, y, d+1)) ;
            } 
              if(y-1>=0 && vis[x][y-1] == -1 && grid[x][y-1]==0){
                vis[x][y-1] = d+1;
                q.add(new Node(x, y-1, d+1)) ;
            } 
              if(x-1 >=0 && y+1 < n && vis[x-1][y+1] == -1 && grid[x-1][y+1]==0){
                vis[x-1][y+1] = d+1;
                q.add(new Node(x-1, y+1, d+1)) ;
            } 
              if(x+1 < n && y+1 < n && vis[x+1][y+1] == -1 && grid[x+1][y+1]==0){
                vis[x+1][y+1] = d+1;
                q.add(new Node(x+1, y+1, d+1)) ;
            } 
              if(x+1 < n && y-1 >=0 && vis[x+1][y-1] == -1 && grid[x+1][y-1]==0){
                vis[x+1][y-1] = d+1;
                q.add(new Node(x+1, y-1, d+1)) ;
            } 
              if(x-1 >= 0 && y-1 >= 0 && vis[x-1][y-1] == -1 && grid[x-1][y-1]==0){
                vis[x-1][y-1] = d+1;
                q.add(new Node(x-1, y-1, d+1)) ;
            } 
        }

        return vis[n-1][n-1] ;
    }
}