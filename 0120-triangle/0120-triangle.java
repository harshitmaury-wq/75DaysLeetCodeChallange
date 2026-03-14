class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[201][201];
        for(int[] r: dp) Arrays.fill(r, Integer.MAX_VALUE);
        return fun(triangle, 0, 0, dp);
    }
    static int fun(List<List<Integer>>list, int r, int c, int[][] dp){
            if(r==list.size()-1) return list.get(r).get(c);

        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c];
        int same = list.get(r).get(c) + fun(list, r+1, c, dp);
        int right = list.get(r).get(c) + fun(list, r+1, c+1, dp);

        return dp[r][c] = Math.min(same, right);
    }
}