class Solution {
    public int longestStrChain(String[] words) {
        int[][] dp = new int[words.length + 1][words.length + 2] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        ArrayList<String> list = new ArrayList<>() ;
        for(String s : words) list.add(s) ;
        Collections.sort(list, (a,b) -> {return a.length() - b.length() ;}) ;
        for(int i = 0; i<words.length; i++ ) words[i] = list.get(i) ;

        return fun(words, 0, -1, dp) ;
    }
    int fun(String[] words, int i, int prev, int[][] dp){
        if(i==words.length ) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1] ;
        int take = Integer.MIN_VALUE;
        if(prev == -1 || ispred(words[prev], words[i]) )
        take = 1 + fun(words, i+1, i, dp) ;

        int skip = fun(words, i+1, prev, dp) ;

        return dp[i][prev+1] = Math.max(take, skip) ;
    }
    boolean ispred(String a , String b){
        if(b.length()-a.length() != 1) return false ;

        int count = 0;
        int i = 0;
        int j = 0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)!=b.charAt(j)) { j++; count++; }
            else {
                i++;
                j++;
            }
                 
        }
        if(count == 1 ) return true;
        if(i==a.length() && j<b.length()) return true;
        return false ;
    }
}