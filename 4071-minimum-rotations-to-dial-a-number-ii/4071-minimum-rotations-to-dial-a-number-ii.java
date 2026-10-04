class Solution {
    public int minRotations(int num, String s) {
        int[] suf = new int[num] ;
        int in = s.charAt(num-1)-'0' ;

        int steps = 0; 
        for(int i = s.length()-2; i>=0; i--) {
            int n = s.charAt(i) - '0' ;

            if(n >= in) {
                steps += Math.min(n-in, in + 1 + 9 - n) ;
                in = n ;
            }

            else {
                steps += Math.min(in - n, 9 - in + 1 + n) ;
                in = n ;
            }

            suf[i] = steps ;
        }

        int min = 0; 
        in = 0;
        for(int i = 0; i < num ; i++) {
            int n = s.charAt(i) - '0' ;

            if(n >= in) {
                min += Math.min(n-in, in + 1 + 9 - n) ;
                in = n ;
            }

            else {
                min += Math.min(in - n, 9 - in + 1 + n) ;
                in = n ;
            }

        }

        in = 0 ;
        steps = 0 ;
        for(int i = 0; i<num; i++) {
            int n = s.charAt(i) - '0' ;

            if(n >= in) {
                steps += Math.min(n-in, in + 1 + 9 - n) ;
                in = n ;
            }

            else {
                steps += Math.min(in - n, 9 - in + 1 + n) ;
                in = n ;
            }

            if(i == num-1) continue ;
            int temp = steps ;
            int m = s.charAt(num-1)-'0' ;
            if(m >= in) {
                steps += Math.min(m-in, in + 1 + 9 - m) ;
                in = m ;
            }

            else {
                steps += Math.min(in - m, 9 - in + 1 + m) ;
                in = m ;
            }
            
            min = Math.min(min, steps + suf[i+1]) ;
            in = n ;
            steps = temp ;
        }

        steps = 0;
        in = 0;
        int n = s.charAt(num-1) - '0' ;
        
        if(n >= in) {
                steps += Math.min(n-in, in + 1 + 9 - n) ;
                in = n ;
            }

            else {
                steps += Math.min(in - n, 9 - in + 1 + n) ;
                in = n ;
            }

        return Math.min(min, suf[0]+steps) ;

    }

}