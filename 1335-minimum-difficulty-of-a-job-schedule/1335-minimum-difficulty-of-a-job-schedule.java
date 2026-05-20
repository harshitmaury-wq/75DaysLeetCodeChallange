class Solution {
    public int minDifficulty(int[] jd, int d) {
        if(d > jd.length) return -1;

        int[][] dp = new int[jd.length +1][d+1] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;
        return fun(jd, 0, d, dp) ;
    }
    int fun (int[] jd, int s, int d, int[][] dp){
        if(s >= jd.length && d >= 1) return 0;
        if(d == 1) {
            int max = Integer.MIN_VALUE;
            for(int j = s; j < jd.length ; j++){
                max = Math.max(max, jd[j]);
            }
            return max ;
        }

        if(dp[s][d] != -1) return dp[s][d] ;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int S = Integer.MAX_VALUE ;
        for(int i = s; i <= jd.length - d; i++){
            max = Math.max(max, jd[i]);
            sum = max + fun(jd, i+1, d-1, dp) ;
            S = Math.min(sum, S) ;
        }
        return dp[s][d] = S;
    }
}