class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for(long[]ele : dp) Arrays.fill(ele ,-1);
        return (long)fun(nums, 0, 0, dp);
    }
    static long fun (int[] arr, int i, int pari, long[][] dp){
        if(i == arr.length) return 0;
         
         if(dp[i][pari] != -1) return dp[i][pari];
        long take , skip;
        if(pari == 0){
            take =(long) arr[i] + fun(arr, i+1, 1, dp);
            skip =(long) fun(arr, i+1, 0, dp);
        }
        else{
            take = (long) -1*arr[i] + fun(arr, i+1, 0, dp);
            skip = (long)fun(arr, i+1, 1, dp);
        }
        return  dp[i][pari] =(long) Math.max(take, skip);
    }
}