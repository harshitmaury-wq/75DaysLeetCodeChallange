class Solution {
    public int minStartValue(int[] nums) {
        int s = 1;
        int e = 10000 ;

        int ans = -1 ;

        while(s <= e) {
            int mid = s+ (e - s) /2 ;

            int m = mid ;
            for(int i = 0; i<nums.length; i++) {
                m += nums[i] ;
                if(m < 1) break;
            }

            if(m < 1) {s = mid + 1 ;}
            else {ans = mid ; e = mid - 1 ;}
        }


        return ans ;
    }
}