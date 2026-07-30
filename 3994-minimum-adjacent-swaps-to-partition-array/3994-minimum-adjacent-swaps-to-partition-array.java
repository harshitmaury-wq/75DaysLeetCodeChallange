class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int ans = 0;
        int M = 0;
        int R = 0 ;

        for(int i = 0; i<nums.length; i++ ) {
            if(nums[i] >= a && nums[i] <= b) {
                ans +=  R ;
                ans%=1000000007 ;
                M++;

            }
            else if(nums[i] < a) {
                ans += (R+M) ;
                ans%=1000000007 ;

            }
            else R++ ;
             
        }
        return ans%1000000007 ;
    }
}