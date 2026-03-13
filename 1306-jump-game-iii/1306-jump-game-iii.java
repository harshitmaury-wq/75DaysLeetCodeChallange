class Solution {
    public boolean canReach(int[] arr, int start) {
        int[]v = new int[arr.length];
        int[]dp = new int[arr.length];
        
        return fun(arr, start, v, dp);
    }
    static boolean fun(int[] arr, int s, int[] v, int[] dp){
        if(s>=arr.length || s<0 || v[s]==1) return false;
        if(arr[s]==0) return true;

        if(dp[s] != 0){
            if(dp[s]==1) return true;
            else return false;
        }
        v[s] = 1;
        boolean l = fun(arr, s+arr[s], v,dp);
        boolean r = fun(arr, s-arr[s], v,dp);
        v[s] = 0;

        boolean b = l||r;
        if(b) dp[s] = 1;
        else dp[s] = 2;
        return b;
    }
}