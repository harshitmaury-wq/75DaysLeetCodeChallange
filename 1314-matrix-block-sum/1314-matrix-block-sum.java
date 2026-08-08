class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length ;
        int n = mat[0].length ;

        int[][] pre = new int[m][n] ;
        pre[0][0] = mat[0][0] ;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(i == 0 && j == 0) {pre[i][j] = mat[i][j] ; continue; }
                if(i == 0) {pre[i][j] = mat[i][j] + pre[i][j-1] ; continue; }
                if(j == 0) {pre[i][j] = mat[i][j] + pre[i-1][j] ; continue; }

                int top = pre[i-1][j] ;
                int left = pre[i][j-1] ;
                int top_left = pre[i-1][j-1] ;

                pre[i][j] = top + left + mat[i][j] - top_left ;
            }
        }

        int[][] ans = new int[m][n] ;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                
                int top_left_corner = (i-k-1 < 0 || j-k-1 < 0) ? 0 :pre[i-k-1 <0 ? 0:i-k-1][j-k-1<0 ? 0:j-k-1];
                int bottom_right_corner = pre[i+k >= m ? m-1 : i+k][j+k >= n ? n-1 : j+k] ;
                int top_right_corner = i-k-1 < 0 ? 0 :pre[i-k-1][j+k >= n ? n-1 : j+k] ;
                int bottom_left_corner = j-k-1 < 0 ? 0:pre[i+k >= m ? m-1 : i+k][j-k-1] ;


                ans[i][j] = bottom_right_corner - top_right_corner - bottom_left_corner + top_left_corner ;

                
            }
        }
        return ans ;
    }
}