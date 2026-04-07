class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        int mid = 0;
        while(s<=e){
            mid = s+(e-s)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[0]){
                if(target>=nums[0] && target<=nums[mid]) return bs(nums, 0, mid, target);
                else s=mid+1;
            }
            if(nums[mid]<=nums[nums.length-1]){
                if(target>=nums[mid] && target<=nums[nums.length-1]) return bs(nums, mid, nums.length-1, target);
                else e=mid-1;
            }
        }
        return -1;
    }
    static int bs(int[] arr, int a, int b, int target){
        int s=a, e=b;
        int mid;
        while(s<=e){
            mid =s+(e-s)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) e=mid-1;
            else if(arr[mid]<target) s=mid+1;
        }
        return -1;
    }
}