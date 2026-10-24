class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int i = 0; 
        int j = 0;

        long ans = 0 ;
        while(j < nums.length && i< nums.length) {
            if(nums[j] > maxK || nums[j] < minK){
                int n = j - i  ;

                if(n%2 == 0) {
                    long mul = n/2;
                    ans += (long)(mul*(n+1)) ;
                }
                else {
                    long mul = (n+1)/2 ;
                    ans += (long)(mul*n) ;
                }
                i = j+1;
            }
            j++;
        }
        
        int n = j - i  ;
        if(n%2 == 0) {
                long mul = n/2;
                ans += (long)(mul*(n+1)) ;
            }
                else {
                    long mul = (n+1)/2 ;
                    ans += (long)(mul*n) ;
                }

        return ans;
    }
}