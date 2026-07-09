class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int[] t = new int[nums.length] ;
        for(int i = 0; i<nums.length; i++) t[i] = nums[i] ;
        int cnt = 0;
        int n = nums.length ;
        for(int i = 0; i< n-1; i++){
            if(nums[i] == 1) continue;
            else {
                cnt++;
                nums[i]*=-1;
                nums[i+1]*=-1;
            }
        }
        if(cnt <= k && nums[n-1] == 1) return true; 
        cnt = 0;
        for(int i = 0; i< n-1; i++){
            if(t[i] == -1) continue;
            else {
                cnt++;
                t[i]*=-1;
                t[i+1]*=-1;
            }
        }
        if(cnt <= k && t[n-1] == -1) return true;
        return false ;
    }
}