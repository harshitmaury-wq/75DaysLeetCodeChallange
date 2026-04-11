class Solution {
    public int deleteAndEarn(int[] nums) {
    int[] arr = new int[10001] ;

    int max = nums[0] ;
   
    for(int i=0; i<nums.length; i++) {arr[nums[i]]++; max = Math.max(max, nums[i]) ;}
    
    int[] dp = new int[max+1] ;
    Arrays.fill(dp, -1) ;
    return fun(arr, 0, max, dp) ;
       
        
       
    }
    static int fun (int[] arr, int s, int max, int[]dp){

        if(s>max) return 0;

        if(dp[s] != -1) return dp[s] ;
        int take = arr[s]*s + fun(arr, s+2, max, dp) ;

        int skip = fun(arr, s+1, max, dp) ;

        return dp[s] = Math.max(take, skip) ;

       
        
    }
}