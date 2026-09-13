class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        
        
        int[][] a1= new int[n][n] ;

        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++) {
                
                int k = rowShift[i] ;
                a1[i][(j-k+n)%n] = grid[i][j] ;
            }
        }

        int[][] a2 = new int[n][n] ;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {

                int k = colShift[i] ;
                a2[(j-k+n)%n][i] = a1[j][i] ;
            }
        }
        return a2 ;
    }
}