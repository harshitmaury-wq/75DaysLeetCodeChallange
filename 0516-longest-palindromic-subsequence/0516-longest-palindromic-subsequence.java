class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return fun(sb, s, s.length()-1, s.length()-1, dp);

    }
    static int fun(StringBuilder s1, String s2, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = 1+fun(s1, s2, i-1,j-1, dp);
        else{
            return dp[i][j] = Math.max(fun(s1, s2, i, j-1, dp), fun(s1, s2, i-1, j, dp));
        }
    }
}