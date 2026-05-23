class Solution {
    public boolean check(int[] nums) {
        int peak = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] > nums[(i+1)%nums.length] ) peak++;
        }
        if(peak == 0 || peak == 1) return true;
        return false ;
    }
}