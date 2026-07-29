class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length ;
        int[][] vis = new int[m][n] ;

        Queue<int[]> q = new LinkedList<>() ;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if((i == 0 || i==m-1 || j == 0|| j==n-1 ) && vis[i][j]==0 && board[i][j]=='O'){
                    q.add(new int[]{i, j}) ;
                    vis[i][j] = 1;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] t = q.remove() ;
            int x = t[0] ;
            int y = t[1] ;

            if(x + 1 < m && vis[x+1][y] == 0 && board[x+1][y] == 'O' ) {q.add(new int[]{x+1, y} ); vis[x+1][y] = 1 ;} 
            if(x - 1 >= 0 && vis[x-1][y] == 0 && board[x-1][y] == 'O') {q.add(new int[]{x-1, y} ); vis[x-1][y] = 1 ;} 
            if(y + 1 < n && vis[x][y+1] == 0 && board[x][y+1] == 'O') {q.add(new int[]{x, y+1} ); vis[x][y+1] = 1 ;} 
            if(y - 1 >= 0 && vis[x][y-1] == 0 && board[x][y-1] == 'O') {q.add(new int[]{x, y-1} ); vis[x][y-1] = 1 ;} 
        }

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(vis[i][j] == 0 ) board[i][j] = 'X' ;
            }
        }
        
    }
}