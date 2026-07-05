class Solution {
    public int findDuplicate(int[] nums) {
        int f = 0;
        int s = 0;
        boolean fl = true ;
        while(fl || f != s){
            fl = false ;
            s = nums[s] ;
            f = nums[f] ;
            f = nums[f] ;
        }
        s = 0;
        while(f != s){
             s = nums[s] ;
            f = nums[f] ;
        }
        return s ;
    }
}