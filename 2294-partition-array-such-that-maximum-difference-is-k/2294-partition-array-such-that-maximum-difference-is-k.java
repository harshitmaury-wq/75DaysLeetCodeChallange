class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums) ;
        int pivot = nums[0] ;
        int c = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] - pivot > k) {
                c++;
                pivot = nums[i] ;
            }

        }
        return c ;
    }
}