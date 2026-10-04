class Solution {
    public boolean checkValidString(String s) {
        int[][] dp = new int[s.length()][s.length()] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        return fun(s, 0, 0, dp) ;
    }
    boolean fun (String s, int i, int c, int[][] dp) {
        if(c == 0 && i == s.length()) return true ;
        if(c < 0 || i == s.length()) return false ;
        
        if(dp[i][c] != -1) return dp[i][c] == 1 ? true : false ;
        if(s.charAt(i) == ')') {
        boolean b = fun(s, i+1, c-1, dp) ;
        dp[i][c] = (b == true ? 1 : 0) ;
        return b ;
        }
        else if(s.charAt(i) == '(') {
            boolean b = fun(s, i+1, c+1, dp) ;
           dp[i][c] = (b == true ? 1 : 0) ;
           return b ;
        }
        else {
            boolean b = fun(s, i+1, c+1, dp) || fun(s, i+1, c-1, dp) || fun(s, i+1, c, dp) ;
            dp[i][c] = (b == true ? 1 : 0) ;
            return b ;
        }
    }
}