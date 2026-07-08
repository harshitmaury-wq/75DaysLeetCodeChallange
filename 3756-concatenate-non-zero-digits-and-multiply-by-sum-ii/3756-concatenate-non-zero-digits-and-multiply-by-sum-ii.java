class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long[] pre = new long[s.length()] ;
        int mod = 1000000007 ;
        pre[0] = s.charAt(0) - '0' ;

        for(int i = 1; i<pre.length; i++) pre[i] = pre[i-1] + (s.charAt(i)-'0') ;

        long[] pref = new long[s.length()] ;
        long c = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!= '0') c++;
            pref[i] = c ;
        }

        long[] nums = new long[s.length()] ;
        long m = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != '0') {
               m = (m * 10 + (s.charAt(i) - '0')) % mod;
                nums[i] = m ;
            }
            else nums[i] = m ;
        }
        long[] pow = new long[s.length() + 1];
        pow[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
        pow[i] = (pow[i - 1] * 10) % mod;
         }

        int[] ans = new int[queries.length] ;
        for(int i = 0; i<queries.length; i++){
            int l = queries[i][0] ;
            int r = queries[i][1] ;
            if(l == 0) {
                int num =(int) nums[r] ; 
               ans[i] = (int)(((num % mod) * (pre[r] % mod)) % mod);
            }
            else {
            int div =(int) (pref[r] - pref[l-1]);
            
            
           long num = (nums[r] - nums[l-1] * pow[div] % mod + mod) % mod;

            ans[i] = (int) (((num % mod) * ((pre[r] - pre[l-1]) % mod)) % mod);
            }
        }
        return ans ;
    }
}