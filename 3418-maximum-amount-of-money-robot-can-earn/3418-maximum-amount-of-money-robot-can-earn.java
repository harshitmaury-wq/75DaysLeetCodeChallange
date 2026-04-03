class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m+1][n+1][3];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        return fun(coins, 0, 0, m, n, 2, dp);
        
    }
    static int fun(int[][] arr, int r, int c , int m, int n, int neu, int[][][]dp){
        if(r>=m || c>=n) return Integer.MIN_VALUE;
        if(r==m-1 && c==n-1) {
            if(arr[r][c] >= 0) return arr[r][c];

            else {
                if(neu > 0) return 0;
                else return arr[r][c];
            }
        }

        if(dp[r][c][neu] != Integer.MAX_VALUE) return dp[r][c][neu]; 

        if(arr[r][c] < 0){
            int neuright = Integer.MIN_VALUE, neudown = Integer.MIN_VALUE;
            if(neu > 0) neuright = 0+fun(arr,r,c+1,m,n,neu-1, dp);
            int right =  fun(arr,r,c+1, m,n,neu, dp);
            if(right != Integer.MIN_VALUE) right += arr[r][c] ;


            if(neu > 0) neudown = 0+fun(arr,r+1,c,m,n,neu-1, dp);
            int down =  fun(arr,r+1,c, m,n,neu, dp);
            if(down != Integer.MIN_VALUE) down += arr[r][c] ;

            return dp[r][c][neu] = Math.max(Math.max(neuright,right), Math.max(neudown,down));
        }
        else {
            int right = arr[r][c] + fun(arr,r,c+1, m,n,neu, dp);
            int down = arr[r][c] + fun(arr,r+1,c, m,n,neu, dp);

            return dp[r][c][neu] = Math.max(right, down);
        }

    }
}