class Solution {
    public double angleClock(int hour, int minutes) {
        double min = hour * 60 + minutes;

        double ans =(double) Math.abs( (min/2.0 - minutes * 6 )) ;
        return Math.min (ans , 360.0 - ans ) ;
    }
}