class Solution {
    public int maximumDifference(int[] nums) {
        int[] suf = new int[nums.length] ;
        int[] pre = new int[nums.length] ;

        pre[0] = nums[0] ;
        suf[nums.length-1] = nums[nums.length-1] ;

        for(int i = 1; i<nums.length; i++) {
            pre[i] = Math.min(pre[i-1], nums[i]) ;
        }

        for(int i = nums.length-2; i>=0; i--) {
            suf[i] = Math.max(nums[i], suf[i+1]) ;
        }

        int ans = 0;

        for(int i = 0; i<nums.length; i++) {
            ans = Math.max(ans, suf[i] - pre[i]) ;
        }

        if(ans == 0) return -1;
        return ans ;
    }
}