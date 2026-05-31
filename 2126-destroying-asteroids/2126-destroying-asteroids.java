class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Stack<Long> st = new Stack<>() ;

        Arrays.sort(asteroids) ;
        if(asteroids[0] > mass) return false ;

        st.push((long)mass) ;
        int i = 0;
        while(i<asteroids.length && st.peek() >= asteroids[i]){
            long a = st.pop();
            st.push(a + asteroids[i]) ;
            i++ ;
        }
        if(i==asteroids.length) return true;
        return false  ;
    }
}