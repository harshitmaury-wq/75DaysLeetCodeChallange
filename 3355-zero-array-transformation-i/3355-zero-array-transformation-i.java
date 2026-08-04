class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] dat = new int[nums.length] ;

        for(int i = 0; i<queries.length; i++) {
            dat[queries[i][0]]+=(-1) ;
            if(queries[i][1] != dat.length - 1 ) dat[queries[i][1] + 1]+=1 ;

        }

        for(int i = 1; i<dat.length; i++) dat[i] += dat[i-1] ;
        boolean b = false ;
        for(int i = 0; i<nums.length; i++){
        nums[i] = nums[i] + dat[i] ;
        if(nums[i] > 0) b = true ;
        }
        if(b) return false ;
        return true ;
    }
}