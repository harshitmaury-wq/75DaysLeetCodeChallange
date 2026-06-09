class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        return fun(s,p,0,0, dp) ;
    }
    boolean fun (String s, String p, int i, int j, int[][] dp) {
    if(i==s.length() && j==p.length()) return true;
    if(i!=s.length() && j==p.length()) return false ;
    if(i == s.length()) {

    while(j < p.length() && p.charAt(j) == '*')
        j++;

    return j == p.length(); 
    }

    if(dp[i][j] != -1) return dp[i][j]==1 ? true : false ;

    boolean b ;
    if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') b = fun(s,p,i+1,j+1, dp) ;

    else if(p.charAt(j)=='*') {
       b = fun(s,p,i, j+1, dp) || fun(s, p, i+1, j, dp) || fun(s,p,i+1, j+1, dp);
    }
       else b = false ;

       if(b) {
        dp[i][j] = 1;
        return b;
       }
       else {
        dp[i][j] = 0;
        return b ;
       }
    }
}