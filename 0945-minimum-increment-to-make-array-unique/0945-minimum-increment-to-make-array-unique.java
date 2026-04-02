class Solution {
    public int minIncrementForUnique(int[] nums) {
       
        int count  =0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i] <= nums[i-1]){
                int t = nums[i];
                nums[i] = nums[i-1] +1 ;
              
                count += nums[i] - t;
            }
            
        }
        return count;
    }
}