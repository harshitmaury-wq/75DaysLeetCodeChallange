class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n/2;

        int count = 0;
        Arrays.sort(nums);
        while(j<n && i<n/2){
           
            if(2*nums[i] <= nums[j]){
            j++ ;
            i++;
            count+=2;
            }
            else {
                j++;
            }
        }
      
        return count;
    }
}