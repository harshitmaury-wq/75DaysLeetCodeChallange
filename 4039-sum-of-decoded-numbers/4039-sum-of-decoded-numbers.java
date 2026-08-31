class Solution {
    public int sumDecoded(long[] nums) {
        long sum = 0 ;
        for(int i = 0; i<nums.length; i++) {
            int w = (int)(nums[i] % 10) ;
            long d = nums[i]/10 ;

            StringBuilder sb = new StringBuilder() ;

            sb.append(d) ;

            long x = Long.parseLong(sb.substring(0, w)) ;
            long n = Long.parseLong(sb.substring(w, sb.length())) ;

            sum += pow(x, n) ;
            sum%=1000000007 ;
        }

        return (int)sum%1000000007 ;
    }
    // x^n
    long pow(long x, long n) {
        if(n == 0) return 1 ;

        long half = pow(x, n/2) ;
        if(n % 2 == 1){
            return x * half %1000000007 * half % 1000000007;
        }
        else return half % 1000000007 * half % 1000000007 ;
    }
}