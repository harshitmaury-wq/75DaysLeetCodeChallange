class Solution {
    public String stoneGameIII(int[] sv) {
        int[] dp = new int[sv.length + 1] ;
        Arrays.fill(dp, Integer.MAX_VALUE) ;

        int ans= fun(sv, 0, dp) ;
        if(ans > 0) return "Alice" ;
        else if(ans == 0) return "Tie" ;
        else return "Bob" ;
    }
    static int fun(int[] sv, int s, int[] dp) {
        if(s>=sv.length) return 0;

        if(dp[s] != Integer.MAX_VALUE) return dp[s] ;
        int one = sv[s] - fun (sv, s+1, dp) ;
        int two = Integer.MIN_VALUE ;
        int three = Integer.MIN_VALUE ;
       if(s+1 < sv.length) two = sv[s] + sv[s+1] - fun(sv, s+2, dp) ;
       if(s+2 < sv.length)  three = sv[s] + sv[s+1] + sv[s+2] - fun(sv, s+3, dp) ;

       return dp[s] = Math.max(one, Math.max(two, three)) ;
    }
}