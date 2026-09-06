class Solution {
    public int countGoodRotations(int[] nums) {
        
        long sum1 = 0; 
        long sum2 = 0; 

        int i = 0;
        int j = nums.length/2 ;

        while(j < nums.length) {
            sum1 += nums[i] ;
            sum2+=nums[j] ;
            i++; j++; 
        }

        i = 0; 
        j = nums.length/ 2 ;

        int grt = 0; 
        int sm = 0;

        while(j < nums.length) {
            if(sum1 > sum2) grt++;
            else if(sum1 < sum2) sm++ ;

            sum1 -= nums[i] ;
            sum2 += nums[i] ;

            sum2-=nums[j] ;
            sum1 += nums[j] ;

            i++; j++ ;
        }

        return sm + grt ;
    }
}