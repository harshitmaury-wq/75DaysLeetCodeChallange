class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums) ;
        long[] pre = new long[nums.length] ;
        long[] suf = new long[nums.length] ;

        pre[0] = nums[0] ;
        suf[nums.length - 1] = nums[nums.length -1 ] ;

        for(int i = 1; i<nums.length; i++) pre[i] = pre[i-1] + nums[i] ;
        for(int i = nums.length-2; i>=0; i--) suf[i] = suf[i+1] + nums[i] ; 

        long min = Long.MAX_VALUE ;
        int last = nums.length -1 ;
        for(int i = 0; i<nums.length; i++) {
            long presum = i == 0 ? 0 : pre[i-1] ;
            long sufsum = i == last ? 0 : suf[i+1] ;

            long op = ( 1L*i*nums[i] - presum + sufsum - (1L*(last - i)*nums[i])) ;
            min = Math.min(op, min ) ;
        }

        return (int)min ;
    }
}