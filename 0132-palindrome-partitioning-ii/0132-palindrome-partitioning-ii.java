class Solution {
    public int minCut(String s) {
        if(is(s)) return 0;
        int[]dp = new int[s.length()+1];
        Arrays.fill(dp, -1);

        return fun(s, 0, dp)-1;
    }
    static int fun (String s, int st, int[]dp){
        if(st==s.length()) return 0;

        if(dp[st] != -1) return dp[st];
        int min = Integer.MAX_VALUE;
        int par = 0;
        for(int i=st; i<s.length(); i++){
            if(is(s.substring(st,i+1))){
                par = 1+fun(s,i+1, dp);
                min = Math.min(min, par);
            }
        }
        return dp[st] = min;
       
    }
    static boolean is(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}