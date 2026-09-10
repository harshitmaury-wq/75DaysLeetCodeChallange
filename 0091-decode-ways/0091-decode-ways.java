class Solution {
    public int numDecodings(String s) {
        int[] dp =new int[s.length()] ;
        Arrays.fill(dp, -1) ;

        return fun(s, 0, dp) ;
    }
    int fun(String s , int st, int[] dp) {
        if(st == s.length()) return 1 ;
        int c = 0;
        
        if(dp[st] != -1) return dp[st] ;
        for(int i = st; i<s.length(); i++) {
            int n = Integer.parseInt(s.substring(st,i+1)) ;
            if(1 <= n && n <= 26 ){
                c += fun(s, i+1, dp) ;
            }
            else break;
        }
        return dp[st] = c ;
    }
}