class Solution {
    public int maxJumps(int[] arr, int d) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length] ;
        Arrays.fill(dp, -1) ;
        for(int i=0 ; i<arr.length; i++){
            max = Math.max(max, solve(arr, i, d, dp));
        }
        return max;
    }
    int solve(int[]arr, int i, int d, int[]dp){
        
        if(dp[i] != -1) return dp[i] ;
        int res = 1;
        for(int j=i-1; j>=Math.max(0, i-d); j--){
            if(arr[i] <= arr[j]) break ;
            res = Math.max(res, 1 + solve(arr, j, d, dp));
        }
        for(int j=i+1; j<=Math.min(arr.length-1, i+d); j++){
            if(arr[i] <= arr[j]) break ;
            res = Math.max(res, 1 + solve(arr, j, d, dp));
        }
        return dp[i] = res;
    }
}