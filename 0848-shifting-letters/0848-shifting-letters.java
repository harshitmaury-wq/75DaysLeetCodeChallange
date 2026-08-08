class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long[] suf = new long[shifts.length] ;
        suf[suf.length - 1] = shifts[shifts.length - 1] ;

        for(int i =shifts.length-2 ;i>=0; i--){
            suf[i] = suf[i+1] + shifts[i] ;
        }

        StringBuilder sb = new StringBuilder() ;
        for(int i = 0; i<s.length(); i++) {
            long mod = suf[i] % 26 ;

            long x = s.charAt(i) - 'a';

            x = (x + mod) % 26;
            sb.append((char)('a' + x)) ;
        }
        return sb.toString() ;
    }
}