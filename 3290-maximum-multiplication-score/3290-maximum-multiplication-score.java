class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp = new long[a.length][b.length] ;
        for(long[] ele : dp) Arrays.fill(ele, Long.MAX_VALUE) ;

        return fun(a, b, 0, 0, dp) ;
    }
    long fun(int[] a, int[] b , int i, int j, long[][] dp) {
        if(i == a.length && j == b.length ) return 0;
        if( i == a.length) return 0 ;
        if(j == b.length) return Long.MIN_VALUE ;
            
        if(dp[i][j] != Long.MAX_VALUE) return dp[i][j] ;
        long take = fun(a, b, i+1, j+1, dp) ;
        if(take != Long.MIN_VALUE) take += 1L*a[i]*b[j] ;
        long skip = fun(a, b, i, j+1, dp) ;

        return dp[i][j] = Math.max(skip, take) ;
    }
}