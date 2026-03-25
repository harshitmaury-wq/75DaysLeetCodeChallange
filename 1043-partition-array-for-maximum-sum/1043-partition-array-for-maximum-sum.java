class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        return fun(arr, k, 0, dp);
    }
    static int fun (int[] arr, int k, int s, int[]dp){
        if(s==arr.length) return 0;


        if(dp[s] != -1) return dp[s];
        int max = Integer.MIN_VALUE;
        int runmax = Integer.MIN_VALUE;
        for(int i=1; i<=k && s + i <= arr.length; i++){
            runmax = Math.max(arr[s+i-1], runmax);
            int sum = i*runmax + fun(arr, k, s+i, dp);
            max = Math.max(max, sum);
        }
        return dp[s] = max;
    }

    static int mx(int[] arr, int a , int b){
        int mx = arr[a];
        for(int i=a; i<=b; i++) mx = Math.max(mx, arr[i]);
        return mx;
    }
}