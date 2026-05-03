class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i=0;
        int j= nums.length-1;
        int k = nums.length-1;
        while(j>=i){
            if(nums[j]*nums[j]>nums[i]*nums[i]) {arr[k] = nums[j]*nums[j]; j--;}
            else  {arr[k] =nums[i]*nums[i]; i++;}
            k--;
        }
        return arr;
    }
}