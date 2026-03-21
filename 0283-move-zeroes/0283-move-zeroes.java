class Solution {
    public void moveZeroes(int[] nums) {
        int j=-1;
        
        if (nums.length==1) return;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) {
                j=i; break;
            }
        }
        if(j!=-1){
        for(int i=j+1; i<nums.length; i++){
            if(nums[i]!=0) {swap(nums, i,j); j++;}
        }
        }
    }
    static void swap(int[] ar, int a, int b){
        int temp=ar[a];
        ar[a]=ar[b];
         ar[b]=temp;
    }
}