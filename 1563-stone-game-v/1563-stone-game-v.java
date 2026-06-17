class Solution {
    public int stoneGameV(int[] sv) {
        int[][] dp = new int[sv.length+1][sv.length+1] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        int[] pre = new int[sv.length + 1] ;
        pre[0] = 0 ;
        pre[1] = sv[0] ;
        int p = 2 ;
        for(int i = 1; i<sv.length; i++) {pre[p] = sv[i] + pre[p-1] ; p++ ;}

        return fun(sv, 0, pre, sv.length -1, dp) ;
    }
    int fun (int[] sv, int s, int[] pre, int e, int[][] dp) {
        if(e - s + 1 == 1) return 0;

        if(dp[s][e] != -1) return dp[s][e] ;
        int S = 0;
        int score = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = s ; i<=e ; i++){
            S += sv[i] ;
            if(S > pre[e+1] - pre[s] - S) {
                score = pre[e+1] - pre[s] - S + fun(sv, i+1, pre, e, dp) ;
            }
            else if(S < pre[e+1] - pre[s] - S) {
                score = S + fun(sv, s, pre, i, dp) ;
            }
            else {
                score = Math.max(S + fun(sv, i+1, pre, e, dp), S + fun(sv, s, pre, i, dp) ) ;
            }
            ans = Math.max(ans, score) ;
        }
        return dp[s][e] = ans ;
    }
}