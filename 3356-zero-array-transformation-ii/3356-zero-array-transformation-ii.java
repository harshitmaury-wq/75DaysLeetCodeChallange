class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int s = 0 ;
        int e = queries.length ;
        int ans = -1 ;

        while(s <= e) {
            int mid = s + (e - s) / 2 ;


            int[] dat = new int[nums.length] ;
            int i = 0;
            int t = mid ;
            while(t > 0) {
                dat[queries[i][0]]+=(-1*queries[i][2]) ;
                if(queries[i][1] != dat.length-1) dat[queries[i][1] + 1]+=(queries[i][2]) ;
                i++ ;
                t--;
            }
            for(int j = 1; j<dat.length; j++) dat[j] = dat[j] + dat[j-1] ;
            boolean b= false ;
            for(int j = 0; j<nums.length; j++) {
                if(nums[j] + dat[j] > 0) {b = true; break ; }
            }

            if(b) s = mid + 1 ;
            else {ans = mid ; e = mid - 1 ; } 
        }

        
        return ans; 
    }
}