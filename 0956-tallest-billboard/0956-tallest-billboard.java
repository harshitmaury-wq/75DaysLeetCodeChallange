class Solution {
    public int tallestBillboard(int[] rods) {
        
        int[][] dp = new int[10001][21] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        int ans = fun(rods, 0, 0, dp) ;
        return ans/2 ;
    }
    int fun (int[] rods, int diff, int s, int[][] dp) {
        if(s == rods.length ) {
            if(diff == 0) return 0;
            else return Integer.MIN_VALUE ;
        }

        if(dp[diff+5000][s] != -1) return dp[diff+5000][s] ;
        int add_1 = rods[s] + fun(rods, diff + rods[s], s+1, dp) ;
        int add_2 = rods[s] + fun(rods, diff - rods[s], s + 1, dp) ;
        int not_add = fun(rods,diff, s+1, dp) ;

        return dp[diff+5000][s] = Math.max(add_1, Math.max(add_2, not_add)) ;
    }
}