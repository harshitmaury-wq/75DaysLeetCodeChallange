class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] ele: dp) Arrays.fill(ele, -1);
        return fun(s, 0, s.length()-1, dp);
    }
    static int fun(String s, int i, int j, int[][]dp){
        if(i==j || i>j ) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j] = fun(s, i+1, j-1, dp);
        return dp[i][j] = Math.min(1+fun(s, i, j-1, dp), 1+fun(s, i+1, j, dp));
    }
}