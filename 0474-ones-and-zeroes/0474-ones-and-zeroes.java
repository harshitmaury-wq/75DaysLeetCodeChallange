class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<m+1; j++){
                for(int k=0; k<n+1; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(strs, 0, m, n, dp);
    }
    static int fun(String[] arr, int i, int z, int o, int[][][] dp){
        if(z==0 && o==0) return 0;
        if(z<0 || o<0) return Integer.MIN_VALUE;
        if(i==arr.length) return 0;

        if(dp[i][z][o] != -1) return dp[i][z][o] ;
        int one =0;
        int zero = 0;
        for(int j=0; j<arr[i].length(); j++){
            if(arr[i].charAt(j)=='0') zero++;
            else one++;
        }
        int take = 1+fun(arr, i+1, z-zero, o-one, dp);
        int skip = fun(arr, i+1, z, o, dp);
        return dp[i][z][o] = Math.max(take, skip);
    }
}