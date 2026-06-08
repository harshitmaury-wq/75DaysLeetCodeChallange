class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+3];
       for(int[]ele : dp) Arrays.fill(ele, -1);
        return fun(nums, 0, -1, dp);
    }
    static int fun(int[] arr, int i, int p, int[][] dp){
        if(i==arr.length) return 0;

        if( dp[i][p+1] != -1) return dp[i][p+1];
        int skip, take = Integer.MIN_VALUE;
        if(p == -1 || arr[i] > arr[p]) {
             take = 1 + fun(arr, i+1, i, dp);
             skip = fun(arr, i+1, p, dp);
        }
        else{
             skip = fun(arr, i+1, p, dp);
        }
        return dp[i][p+1] = Math.max(take, skip);
    }
}