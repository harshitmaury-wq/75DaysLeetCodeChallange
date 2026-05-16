class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
       
        while(s<e){
            while(s < nums.length-1 && nums[s] == nums[s+1]) s++;
            while(e > 0 && nums[e] == nums[e-1]) e--;

            int mid = s - ( s - e ) / 2;

            if(nums[mid] > nums[e]) s = mid + 1;
            else if(nums[mid] < nums[e] ) { e = mid ; }
          
        }

        return nums[e] ;
    }
}