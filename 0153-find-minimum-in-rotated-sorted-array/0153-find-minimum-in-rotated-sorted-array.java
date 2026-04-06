class Solution {
    public int findMin(int[] nums) {
        int s=0;
        int e=nums.length-1;
        int mid;
        if(nums[0] <= nums[nums.length-1]) return nums[0];

        while(s<=e){
            mid= s+(e-s)/2;
           if(nums[mid] < nums[(mid+1)%nums.length] && nums[mid]<nums[(mid+nums.length-1)%nums.length]) return nums[mid];
           else if(nums[0] <= nums[mid]) s=mid+1;
           else if(nums[mid] <= nums[nums.length-1]) e=mid-1;
        }
        return -1;
    }
}