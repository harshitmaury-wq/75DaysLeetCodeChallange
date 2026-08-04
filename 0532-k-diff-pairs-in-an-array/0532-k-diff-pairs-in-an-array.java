class Solution {
    public int findPairs(int[] nums, int k) {
        int c = 0;
        Arrays.sort(nums) ;
        for(int i = 0; i<nums.length; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue ;
            if(bs(nums, nums[i] + k, i+1, nums.length - 1)) c++;
        }
        return c ;
    }
    boolean bs (int[] nums, int t, int s, int e) {
        
        while(s <= e) {
            int mid = s + (e - s) / 2 ;

            if(nums[mid] < t) s = mid + 1;
            else if(nums[mid] > t) e = mid - 1 ;
            else return true ;
        }
        return false ;
    }
}