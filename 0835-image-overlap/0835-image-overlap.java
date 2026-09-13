class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length ;

        int max = Integer.MIN_VALUE ;
        for(int rof = -1*n+1; rof < n; rof++) {
            for(int cof = -1*n+1; cof < n; cof++){
                int c = 0;
                for(int i = 0; i<n; i++){
                    for(int j = 0; j<n; j++) {
                        int x = i+rof;
                        int y = j+cof ;
                        if(img1[i][j] == 1 && x < n && x>=0 && y>= 0 && y<n && img2[x][y]==1) c++;
                    }
                }
                max = Math.max(max, c) ;
            }
        }

        return max ;
    }
}