class Solution {
    public int maxCoins(int[] nums) {
        
        int[] arr = new int[nums.length+2];
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] ele: dp) Arrays.fill(ele, -1); 
        arr[0] = 1;
        arr[arr.length-1] =1;
        int j=0;
        for(int i=1; i<arr.length-1; i++) {arr[i] = nums[j]; j++; }
        return fun(arr, 1, arr.length-2, dp);

    }

    static int fun(int[] arr, int l, int r, int[][] dp) {
        if (l > r) return 0;

        if(dp[l][r] != -1) return dp[l][r];
        int max = 0;

        for (int i = l; i <= r; i++) {

            int coins = arr[l - 1] * arr[i] * arr[r + 1]
                      + fun(arr, l, i - 1, dp)
                      + fun(arr, i + 1, r, dp);

            max = Math.max(max, coins);
        }

        return dp[l][r] = max;
    }

    
}