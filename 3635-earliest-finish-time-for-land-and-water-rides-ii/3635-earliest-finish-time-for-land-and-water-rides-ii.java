class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landDuration.length ;
        int m =  waterDuration.length ;
        int[] etl = new int[n] ;
        int[] etw = new int[m] ;

        for(int i=0; i<n; i++){
            etl[i] = landStartTime[i] + landDuration[i] ;
            
        }
        for(int i=0; i<m; i++){
            etw[i] = waterStartTime[i] + waterDuration[i] ;
        }

      

        int m1 = etl[0] ;
        for(int i=0; i<n; i++) m1 = Math.min(m1, etl[i]) ;

          int m2 = etw[0] ;
        for(int i=0; i<m; i++) m2 = Math.min(m2, etw[i]) ;

        int min1 = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            if(waterStartTime[i] < m1) min1 = Math.min(m1+waterDuration[i], min1) ;
            else min1 = Math.min(min1, etw[i]) ;
        }

         

        int min2 = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(landStartTime[i] < m2) min2 = Math.min(m2+landDuration[i], min2) ;
            else min2 = Math.min(min2, etl[i]) ;
        }
        return Math.min(min1, min2) ;
    }
}