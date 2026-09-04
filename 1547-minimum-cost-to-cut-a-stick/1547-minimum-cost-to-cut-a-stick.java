class Solution {
    public int minCost(int n, int[] cuts) {
        
        int[] newcuts = new int[cuts.length+2] ;
        newcuts[0] = 0;
        
        int[][] dp = new int[newcuts.length][newcuts.length] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        Arrays.sort(cuts) ;
        newcuts[newcuts.length - 1] = n ;

        int x = 1;
        for(int i = 0; i<cuts.length; i++) {
            newcuts[x++] = cuts[i] ;
        }

        return fun(newcuts, 0, newcuts.length-1, dp) ;
    }
    int fun (int[] cuts, int s, int e, int[][] dp) {
        if(e - s <= 1) return 0 ;

        if(dp[s][e] != -1) return dp[s][e] ;
        int min = Integer.MAX_VALUE ;
        for(int i = s+1 ; i< e ; i++) {
            min = Math.min(min, cuts[e]-cuts[s] + fun(cuts, s, i, dp) + fun(cuts, i, e, dp)) ;
        }

        return dp[s][e] = min ;
    }
}