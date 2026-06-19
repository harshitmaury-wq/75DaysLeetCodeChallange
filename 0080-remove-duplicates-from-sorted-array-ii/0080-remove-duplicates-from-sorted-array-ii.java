class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int n = 1; 
        int i = 1;
        int j = 1;

        while(j<nums.length) {
            if(nums[j] == nums[j-1]) n++;
            else n = 1;

            if(n==1 || n==2) {
                nums[i] = nums[j] ;
                i++; j++;
            }
            else j++;
        }
        return i ;
    }
}