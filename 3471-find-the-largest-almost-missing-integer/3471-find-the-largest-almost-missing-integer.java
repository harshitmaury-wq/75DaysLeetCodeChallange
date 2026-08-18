class Solution {
    public int largestInteger(int[] nums, int k) {
        
        int[] arr = new int[51] ;

         int mx = Integer.MIN_VALUE ;
        for(int i : nums) {
            mx = Math.max(i, mx) ;
            arr[i]++;
        }

        if(k == nums.length ) return mx;

        if( k == 1) {
            for(int i = arr.length-1; i>=0; i--) {
                if(arr[i] == 1) return i ;
            }
        }
        
        if(arr[nums[0]] == 1 && arr[nums[nums.length-1]]==1)
        return Math.max(nums[0], nums[nums.length - 1]) ;

        else if(arr[nums[0]] == 1 && arr[nums[nums.length-1]]>1)
        return nums[0] ;

        else if(arr[nums[0]] > 1 && arr[nums[nums.length-1]] == 1)
        return nums[nums.length -1] ;

        else return -1 ;
        
    }
}