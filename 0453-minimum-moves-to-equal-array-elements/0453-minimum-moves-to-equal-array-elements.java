class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums) ;

        int min = nums[0] ;
        int ans = 0;

        for(int i = 0; i<nums.length; i++) {
            ans += nums[i] - min ;

            
        }

        return ans ;
    }
}