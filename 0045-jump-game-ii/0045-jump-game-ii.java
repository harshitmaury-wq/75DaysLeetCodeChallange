class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return fun(nums, 0, dp);
    }
    static int fun(int[]arr, int s, int[] dp){
        if(s>=arr.length-1) return 0;
        
        if(dp[s] != -1) return dp[s];
        int min = 50000;
        int jump= 0;
        for(int i=1; i<=arr[s]; i++){
                jump = 1+fun(arr, s+i,dp);
                min = Math.min(min, jump);
            
        }
        return dp[s] = min;
    }
}