class Solution {
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        int j=0;
        for(int i=1; i<arr.length-1; i++) {arr[i] = cuts[j]; j++; }
        arr[0] = 0;
        arr[arr.length-1] = n;
        Arrays.sort(arr);
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] ele : dp) Arrays.fill(ele, -1);
        return fun(arr, 0, arr.length-1, dp);
        
    }
    static int fun (int[] arr, int l, int r, int[][]dp){
     if (r - l <= 1) return 0;

        if(dp[l][r] != -1) return dp[l][r];
        int min = Integer.MAX_VALUE;
        for(int i = l+1; i<=r-1; i++){
            int cost = arr[r]-arr[l] + fun(arr, l, i, dp) + fun(arr, i, r , dp);
            min = Math.min(min, cost);
        }
        return dp[l][r] = min;
    }
}