class Solution {
    public long maxRatings(int[][] units) {
        long sum = 0;
        int[][] arr = new int[units.length][2] ;

        for(int i = 0; i< units.length; i++){
            int fmin = Integer.MAX_VALUE ;
            int smin = Integer.MAX_VALUE ;
            for(int j = 0; j < units[i].length; j++){
                if(units[i][j] < fmin) {
                    smin = fmin;
                    fmin = units[i][j] ;
                }
                else if(units[i][j] < smin) smin = units[i][j] ;
            }
            if(smin == Integer.MAX_VALUE) smin = fmin ;
            arr[i][0] = fmin;
            arr[i][1] = smin;
            sum+=smin;
        }
        int mfm = Integer.MAX_VALUE;
        int msm = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length; i++){
            mfm = Math.min(mfm, arr[i][0]) ;
            msm = Math.min(msm, arr[i][1]) ;
        }
        return (long)sum - msm + mfm ;
    }
}