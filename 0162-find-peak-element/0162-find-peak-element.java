class Solution {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        int mid;
        while(s != e){
            mid= s+ (e-s)/2;
            if(nums[mid]<nums[mid+1])
            s=mid+1;
            if(nums[mid]>nums[mid+1])
            e=mid;
        }
        return s;
    }
}