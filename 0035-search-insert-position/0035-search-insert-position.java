class Solution {
    public int searchInsert(int[] nums, int target) {
        int st=0;
        int e=nums.length-1;
        int mid;
        while(st<=e){
            mid= st+(e-st)/2;
            if(target>nums[mid])
            st=mid+1;
            if(target<nums[mid])
            e=mid-1;
            if(target==nums[mid])
            return mid;
        }
        return st;
    }
}