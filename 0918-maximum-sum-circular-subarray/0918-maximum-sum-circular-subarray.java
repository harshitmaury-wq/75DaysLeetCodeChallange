class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        

        int maxsub = Integer.MIN_VALUE ;
        int minsub = Integer.MAX_VALUE ;

        int total = 0;
        int currmax = 0;
        int currmin = 0;

        for(int i = 0; i<nums.length; i++) {
            total += nums[i] ;
            
            currmax = Math.max(nums[i], currmax + nums[i]) ;
            maxsub = Math.max(maxsub, currmax) ;

            currmin = Math.min(nums[i], currmin + nums[i]) ;
            minsub = Math.min (minsub, currmin) ;


        }

        if(maxsub < 0) return maxsub ;

        return Math.max(total - minsub, maxsub) ;
    }
}