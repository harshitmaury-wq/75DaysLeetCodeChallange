class Solution {
    
    public int minFallingPathSum(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[][] dp = new int [r+2][c+2];
        for(int[] ele : dp) Arrays.fill(ele,Integer.MAX_VALUE);
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(i==1) dp[i][j]=arr[i-1][j-1];
                else if (j==1 && i!= 1){
                    dp[i][j] = arr[i-1][j-1] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else {
                    dp[i][j] = arr[i-1][j-1] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
            }
            
        }
        int ans = Integer.MAX_VALUE;

            for(int i=1; i<=c; i++) ans = Math.min(ans, dp[r][i]);
            return ans;
        // int n = matrix.length;
        // int[][] dp = new int[n][n];
        // for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        // int min = Integer.MAX_VALUE;
        // for(int i=0; i<n; i++) min = Math.min(min, fun(matrix, 0, i, dp, n));
        // return min;
        
    }
    static int fun(int[][] arr, int r, int c, int[][] dp, int n){
        if( c>=n || c<0 ) return 300000;
        if(r==n-1) return dp[r][c] = arr[r][c];
        
        

        if(dp[r][c] != -1) return dp[r][c]; 
        int below = arr[r][c]+ fun(arr, r+1, c, dp, n);
        int lbelow = arr[r][c]+ fun(arr, r+1, c-1, dp, n);
        int rbelow = arr[r][c]+ fun(arr, r+1, c+1, dp, n);

        return dp[r][c] = Math.min(below, Math.min(lbelow, rbelow));
        
    }
}