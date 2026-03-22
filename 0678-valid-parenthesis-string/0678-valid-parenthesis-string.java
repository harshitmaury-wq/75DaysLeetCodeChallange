class Solution {
    public boolean checkValidString(String s) {
        int[][][] dp = new int[101][101][101];
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                for(int k=0; k<101; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(s, 0, 0, 0, dp);
    }
    static boolean fun (String s, int i, int l ,int r, int[][][] dp){
        if(r>l) return false;
        if(i==s.length()){
            if(l==r) return true;
            else return false;
        } 
        if(dp[i][l][r] != -1) {
            if(dp[i][l][r] == 1) return true;
            return false;
        }
        if(s.charAt(i)=='*'){
            boolean b1 = fun(s, i+1, l, r, dp);
            boolean b2 = fun(s, i+1, l+1, r, dp);
            boolean b3 = fun(s, i+1, l, r+1, dp);
            boolean B= b1||b2||b3;
             if(B) dp[i][l][r] = 1;
             else dp[i][l][r] = 0;
             return B;
        }
        else {
            boolean B = true;
            if(s.charAt(i)==')') B = fun(s, i+1, l, r+1, dp);
            else B = fun(s, i+1, l+1, r, dp);
              if(B) dp[i][l][r] = 1;
             else dp[i][l][r] = 0;
             return B;
        }

    }
}