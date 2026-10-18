class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int max = 1000000000 ;

        int ans = -1 ;

        int s = 1; 
        int e = max ;

        while(s <= e) {
            int mid = s + (e - s) / 2 ;

            long hrs = 0;

            for(int i = 0; i<nums.length; i++) {
                hrs += nums[i]/mid;
                if(nums[i] % mid != 0) hrs++;
                
            }

            if(hrs <= h) {
                ans =  mid;
                e = mid -1  ;
            }

            else s = mid + 1 ;
        }

        return ans ;
    }
}