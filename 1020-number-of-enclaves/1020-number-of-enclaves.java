class Solution {
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x; 
            this.y = y;
        }
    }
    
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visi = new int[m][n] ;

        int totalone = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) totalone++;
                if((i==0 || j==0 || i==m-1 || j==n-1) && visi[i][j]==0 && grid[i][j]==1) fun(grid,visi,new Node(i,j) ,m,n);
            }
        }
        int traversedone = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visi[i][j]==1) traversedone++ ;
            }
        }

        return totalone - traversedone ;

    }
    void fun (int[][] g, int[][] visi, Node s, int m, int n){
        Queue<Node> q = new LinkedList<>() ;

        q.add(s);
        visi[s.x][s.y] = 1;

        while(!q.isEmpty()){
            Node temp = q.remove() ;

            if(temp.y+1 < n && g[temp.x][temp.y+1] == 1 && visi[temp.x][temp.y+1] == 0 ){
                visi[temp.x][temp.y+1] = 1;
                q.add(new Node(temp.x, temp.y+1)) ;
             
            }
            if(temp.y-1 >= 0 && g[temp.x][temp.y-1] == 1 && visi[temp.x][temp.y-1] == 0){
                visi[temp.x][temp.y-1] = 1;
                q.add(new Node(temp.x, temp.y-1)) ;
              
            }
            if(temp.x+1 < m && g[temp.x+1][temp.y] == 1 && visi[temp.x+1][temp.y] == 0){
                visi[temp.x+1][temp.y] = 1;
                q.add(new Node(temp.x+1, temp.y)) ;
           
            }
            if(temp.x-1 >= 0 && g[temp.x-1][temp.y] == 1 && visi[temp.x-1][temp.y] == 0){
                visi[temp.x-1][temp.y] = 1;
                q.add(new Node(temp.x-1, temp.y)) ;
           
            }
        }
    }
}