class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] pre = new long[nums.length] ;
        long[] suff = new long[nums.length] ;

        pre[0] = nums[0] ;
        suff[nums.length- 1] = nums[nums.length-1] ;

        for(int i=1; i<nums.length; i++){
            pre[i] = nums[i] + pre[i-1] ;
        }
        
        for(int i=nums.length-2; i>=0; i--){
            suff[i] = nums[i] + suff[i+1] ;
        }
        int c = 0;
        for(int i=0; i<nums.length-1; i++){
            if(pre[i] >= suff[i+1]) c++;
        }
        return c ;
    }
}