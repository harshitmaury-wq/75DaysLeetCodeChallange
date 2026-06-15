class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder() ;

        while(n >= 2) {
            int t = n % 2 ;
            n/=2;
            sb.append(t) ;
        }
        sb.append(n) ;
        
        int diff = 32 - sb.length() ;
        while(diff > 0) {sb.append(0); diff-- ;}

        int sum = 0;
        int two = 1;

        for(int i = sb.length()-1; i>=0; i--){
            sum += ((sb.charAt(i)-'0') * two );
            two *= 2 ;
        }
        return sum;
    }
}