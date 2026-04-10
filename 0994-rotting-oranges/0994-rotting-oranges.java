class Solution {
 
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> q = new LinkedList<>() ;

        int time = -1;
        int fresh = 0;
        
        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                if(grid[i][j] == 2 ) { q.add(new Node(i, j)); } 
                if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;

        while(!q.isEmpty()) {
            int size = q.size() ;
            while(size != 0){
                Node temp = q.remove() ;
                size--;
                if(temp.y+1 < n && grid[temp.x][temp.y+1]==1 ) {
                    grid[temp.x][temp.y+1]=2;
                    fresh--;
                    q.add(new Node(temp.x, temp.y+1)) ;
                }
                if(temp.y-1 >= 0 && grid[temp.x][temp.y-1]==1 ) {
                    grid[temp.x][temp.y-1]=2;
                    fresh--;
                    q.add(new Node(temp.x, temp.y-1)) ;
                }
                if(temp.x+1 < m && grid[temp.x+1][temp.y]==1 ) {
                    grid[temp.x+1][temp.y]=2;
                    fresh--;
                    q.add(new Node(temp.x+1, temp.y)) ;
                }
                if(temp.x-1 >= 0 && grid[temp.x-1][temp.y]==1 ) {
                    grid[temp.x-1][temp.y]=2;
                    fresh--;
                    q.add(new Node(temp.x-1, temp.y)) ;
                }
            }
            time++;
        }
       
       if(fresh == 0) return time;
       return -1;
        
    }
}