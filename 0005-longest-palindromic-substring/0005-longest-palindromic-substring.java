class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] ele: dp) Arrays.fill(ele, -1);
        int max = Integer.MIN_VALUE;
        int I=0, J=0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(ispalin(s, i, j, dp)){
                    if(j-i+1 > max){
                        max = j-i+1;
                        I=i;
                        J=j;
                    }

                }
                
            }
        }
        return s.substring(I, J+1);
    }
    static boolean ispalin(String s, int a, int b, int[][] dp){
        if(a>b) return true;


        if(dp[a][b] != -1) {
            if(dp[a][b] ==1) return true;
            return false;
        }
        if(s.charAt(a) != s.charAt(b))  { dp[a][b] = 0; return false ;}

        if(s.charAt(a)==s.charAt(b)) {
            boolean b1 = ispalin(s, a+1, b-1, dp);
            if(b1) dp[a][b] = 1;
            else dp[a][b] = 0;
            return b1;
        }
         return false;
    

    }
}