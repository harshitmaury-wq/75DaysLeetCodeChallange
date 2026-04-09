class Solution {
    class Node{
        int x;
        int y;
        Node(int x, int y) {
           this.x = x;
           this.y = y ;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visi = new int[m][n];

        int count = 0;
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && visi[i][j] == 0) {
                count++;
                bfs(visi, grid, new Node(i, j), m , n) ;
                }
            }
        }
        return count ;
    }
     void bfs(int[][] visi, char[][] grid, Node s, int m, int n){
        Queue<Node> q = new LinkedList<>() ;
        q.add(s);
        visi[s.x][s.y] = 1 ;

        while(!q.isEmpty()) {
            Node temp = q.remove() ;
            if(temp.y+1 < n && visi[temp.x][temp.y+1] == 0 && grid[temp.x][temp.y+1] == '1') {q.add(new Node(temp.x,temp.y+1)) ; visi[temp.x][temp.y+1] = 1; }
            if(temp.y-1 >= 0 && visi[temp.x][temp.y-1] == 0  && grid[temp.x][temp.y-1] == '1') {q.add(new Node(temp.x,temp.y-1)) ; visi[temp.x][temp.y-1] = 1; }
            if(temp.x+1 < m && visi[temp.x+1][temp.y] == 0 && grid[temp.x+1][temp.y] == '1') {q.add(new Node(temp.x+1,temp.y)) ; visi[temp.x+1][temp.y] = 1; }
            if(temp.x-1 >= 0 && visi[temp.x-1][temp.y] == 0 && grid[temp.x-1][temp.y] == '1') {q.add(new Node(temp.x-1,temp.y)) ; visi[temp.x-1][temp.y] = 1; }
           
        }
    }
}