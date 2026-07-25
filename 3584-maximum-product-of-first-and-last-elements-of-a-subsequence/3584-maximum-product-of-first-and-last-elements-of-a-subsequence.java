class Solution {
    public long maximumProduct(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE ;

        long ans = Long.MIN_VALUE ;

        for(int i = m-1; i<nums.length; i++) {
             int f = i-m+1 ;

            max = Math.max(max, nums[f]) ;
            min = Math.min(min, nums[f]) ;


           

            ans = Math.max(ans, Math.max(1L*max*nums[i] , 1L*min*nums[i] )) ;
        }
        return ans ;
    }
}