class Solution {
     class Node{
            int r;
            int c;
            Node(int x, int y){
                this.r = x;
                this.c = y;
            }
        }
    public void solve(char[][] board) {
       
        int m = board.length;
        int n= board[0].length;

        int[][] visi = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O' && visi[i][j]==0){
                dfs(visi, new Node(i, j), board, m, n);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visi[i][j]==0) board[i][j] = 'X';
            }
        }
        
       
        
    }
    void dfs(int[][] visi, Node s, char[][]b, int m, int n){
        visi[s.r][s.c] = 1;

        if(s.r+1 <m && visi[s.r+1][s.c]==0 && b[s.r+1][s.c]=='O'){
                dfs(visi, new Node(s.r+1, s.c),b, m, n);
                
            }
            
            if(s.r-1 >=0 && visi[s.r-1][s.c]==0 && b[s.r-1][s.c]=='O'){
                dfs(visi, new Node(s.r-1, s.c),b, m, n);
                
            }
            
            if(s.c+1 <n && visi[s.r][s.c+1]==0 && b[s.r][s.c+1]=='O'){
                dfs(visi, new Node(s.r, s.c+1),b, m, n);
              
            }
            
            if(s.c-1 >=0 && visi[s.r][s.c-1]==0 && b[s.r][s.c-1]=='O'){
                dfs(visi, new Node(s.r, s.c-1),b, m, n);
              
            }

    }
}