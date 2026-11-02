class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums) ;

        int median ;
        int n = nums.length/2 ;

        if(nums.length % 2 == 0) median = ((nums[n-1]+nums[n])/2) ;
        else median = nums[n] ;
        int ans = 0;
        for(int i = 0; i< nums.length; i++) {
            ans += Math.abs(nums[i]-median) ;
        }

        return ans ;
    }
}