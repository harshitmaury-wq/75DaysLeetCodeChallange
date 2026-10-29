class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length ;
        int zero = 0;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zero = i ;
                break ;
            }
        }

        boolean right = true ;
        boolean left = true; 
        for(int i = 0; i<n; i++) {

            if( nums[(zero + i ) % n ] != i ) right = false ;
            if( nums[(zero - i + n) % n ] != i ) left = false ;

        }

        int ans = Integer.MAX_VALUE;

        if(right) {
            ans = Math.min(ans,zero) ;
            ans = Math.min(ans, n-zero+2) ;
        }

        if(left) {
            ans = Math.min(ans, zero + 2) ;
            ans = Math.min(ans, n - zero) ;
        }

        return ans == Integer.MAX_VALUE ? -1: ans ;

    }
}