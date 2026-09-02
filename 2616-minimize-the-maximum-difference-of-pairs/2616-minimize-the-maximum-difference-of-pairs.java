class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums) ;
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;

        for(int i = 0; i<nums.length; i++) {
            min = Math.min(min, nums[i]) ;
            max = Math.max(max, nums[i]) ;
        }

        int s = 0; 
        int e = max - min ;

        int ans =-1 ; 
        while(s <= e) {
            int mid = s + (e - s) / 2 ;

            int c = 0;

            int i = 1; 

            while(i < nums.length) {
                if(nums[i] - nums[i-1] <= mid) {
                    c++;
                    i = i + 2 ;
                }
                else {
                    i++;
                }
            }

            if(c >= p) {ans = mid ; e = mid - 1 ;}
            else s = mid + 1 ;
        }

        return ans ;
    }
}