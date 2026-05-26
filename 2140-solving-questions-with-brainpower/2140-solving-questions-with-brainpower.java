class Solution {
    public long mostPoints(int[][] q) {
        long[] dp = new long[q.length] ;
        Arrays.fill(dp, -1) ;
        return fun(q, 0, dp) ;
    }
    long fun(int[][] arr, int i, long[] dp){
        if(i >= arr.length) return 0;

        if(dp[i] != -1) return dp[i] ;
        long take = arr[i][0] + fun(arr, i+arr[i][1]+1, dp);
        long skip = fun(arr, i+1, dp) ;

        return dp[i] = Math.max (take, skip) ;
    }
}