class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0 ;
        int max = Integer.MIN_VALUE ;
        for(int x : nums) {sum += x ; max = Math.max(max, x) ;}

        int e = sum ;
        int s = max; 
        int ans = -1 ;
        while(s <=e ) {

            int mid = s + (e -s) / 2 ;

            int c = 1 ;
            int su = 0;


            for(int i = 0; i<nums.length; i++) {
                
                su += nums[i] ;

                if(su > mid) { c ++ ; su = nums[i] ;}
            }

            if(c > k) s = mid + 1 ;
            else {ans= mid ; e = mid - 1 ;}
        }

        return ans; 
    }
}