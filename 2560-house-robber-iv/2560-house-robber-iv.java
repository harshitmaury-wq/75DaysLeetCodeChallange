class Solution {
    public int minCapability(int[] nums, int k) {
        int s = 0;

        int max = Integer.MIN_VALUE ;

        for(int x : nums) max = Math.max(max, x) ;
        int e = max ;
        int ans = -1;

        while(s <= e) {
            int mid = s + (e - s) /  2 ;

            int c = 0 ;
            int i = 0;

            while(i < nums.length) {
                if(nums[i] > mid) {
                    i++ ;
                }
                else{
                    i += 2 ;
                    c++ ;
                }
            }

            if(c >= k) {ans = mid ; e = mid -1 ;} 
            else s = mid + 1 ;
        }

        return ans ;
    }
}