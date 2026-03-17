class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return fun(text1, text2, text1.length()-1, text2.length()-1, dp);
    }
    static int fun(String t1, String t2, int i, int j, int[][] dp){
        if(i<0 || j<0 ) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(t1.charAt(i)==t2.charAt(j)) return dp[i][j] = 1+fun(t1, t2, i-1, j-1, dp);
        else{
            return  dp[i][j] = Math.max(fun(t1, t2, i, j-1, dp), fun(t1, t2, i-1, j, dp));
        }
    }
}