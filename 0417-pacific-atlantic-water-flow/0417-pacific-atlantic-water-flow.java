class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length ;
        boolean[][] p = new boolean[m][n] ;
        boolean[][] a = new boolean[m][n] ;

        for(int i=0; i<n; i++) dfs(heights, p, 0, i, m, n) ;
        for(int i=0; i<m; i++) dfs(heights, p, i, 0, m, n) ;
        for(int i=0; i<n; i++) dfs(heights, a, m-1, i, m, n) ;
        for(int i=0; i<m; i++) dfs(heights, a, i, n-1, m, n) ;

        List<List<Integer>> list = new ArrayList<>() ;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(a[i][j] && p[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j) ;
                    list.add(temp) ;
                }
            }
        }

        return list;
    }
    void dfs (int[][] h, boolean[][] p, int r, int c, int m, int n){
        p[r][c] = true;

        if(r+1 < m && h[r+1][c] >= h[r][c] && !p[r+1][c]) dfs(h,p,r+1,c,m,n);
        if(r-1 >= 0 && h[r-1][c] >= h[r][c] && !p[r-1][c]) dfs(h,p,r-1,c,m,n);
        if(c+1 < n && h[r][c+1] >= h[r][c] && !p[r][c+1]) dfs(h,p,r,c+1,m,n);
        if(c-1 >= 0 && h[r][c-1] >= h[r][c] && !p[r][c-1]) dfs(h,p,r,c-1,m,n);
    }

}