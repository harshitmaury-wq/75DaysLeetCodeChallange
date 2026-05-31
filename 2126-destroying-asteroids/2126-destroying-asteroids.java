class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long a = (long)mass ;

        Arrays.sort(asteroids) ;
        if(asteroids[0] > mass) return false ;

        
        int i = 0;
        while(i<asteroids.length && a >= asteroids[i]){
            a += asteroids[i];
            i++ ;
        }
        if(i==asteroids.length) return true;
        return false  ;
    }
}