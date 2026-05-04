class Solution {
    public void sortColors(int[] nums) {
        int max;
        int j;
        for(int i=0;i<nums.length; i++){
            max=0;
            for(j=0; j<=nums.length-i-1;j++){
                if(nums[j]>nums[max]) max=j;
            }
            swap(nums,j-1,max);
        }
    }
    static void swap(int[] arr,int a , int b){
        int temp=arr[b];
        arr[b]=arr[a];
        arr[a]= temp;
    }
}