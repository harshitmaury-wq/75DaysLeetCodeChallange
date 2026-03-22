class Solution {
    public int minRemovals(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][100000];
       for(int[]ele : dp) Arrays.fill(ele, -1);
        int n = fun(nums, target, 0, 0, dp);
        if(n>=0) return nums.length-n;
        else return -1;
    }
    static int fun(int[] arr, int t, int s, int xor,int[][] dp){
        
        if (s == arr.length) {
            if (xor == t) return 0;
            return Integer.MIN_VALUE;}
         
            
        


        if(dp[s][xor] != -1) return dp[s][xor];
        int take =  1+fun(arr, t, s+1, xor^arr[s], dp);
       
        int skip = fun(arr, t, s+1, xor, dp);
        return dp[s][xor]= Math.max(take, skip);
    }
}