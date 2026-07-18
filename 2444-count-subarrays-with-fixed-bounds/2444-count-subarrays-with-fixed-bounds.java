class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastbadidx = -1;
        int lastminidx = -1;
        int lastmaxidx = -1;
        long  ans = 0; 
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK) lastbadidx = i;

            if(nums[i] == minK) lastminidx = i ;

            if(nums[i] == maxK) lastmaxidx = i ;

            ans += Math.max(0, Math.min(lastminidx, lastmaxidx)-lastbadidx) ;
        }
        return ans ;
    }
}