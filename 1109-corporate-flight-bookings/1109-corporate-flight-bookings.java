class Solution {
    public int[] corpFlightBookings(int[][] b, int n) {
        int[] diff = new int[n] ;

        for(int i = 0; i<b.length; i++){
            diff[b[i][0]-1] += b[i][2] ;
            int t = b[i][1] ;
            if(t<diff.length) diff[t] += -1*b[i][2] ;
        }
        for(int i = 1; i<diff.length; i++) diff[i] = diff[i] + diff[i-1] ;
        return diff ;
    }
}