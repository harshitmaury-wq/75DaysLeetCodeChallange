class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return fun(nums, 0, dp);
    }
    static boolean fun (int[] arr, int s, int[] dp){
        if(s>=arr.length-1) return true;

        if(dp[s] != -1) {
            if(dp[s]==1) return true;
            return false;
        }
        
            boolean b = false;
            for(int j=1; j<=arr[s]; j++){
                b = b || fun(arr, s+j, dp);
            }
         if(b) dp[s] = 1;
         else dp[s] = 0;
         return b;
      
    }
}