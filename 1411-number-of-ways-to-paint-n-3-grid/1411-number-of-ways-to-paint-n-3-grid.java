class Solution {
    public int numOfWays(int n) {
        char[] arr = {'R', 'Y', 'G'} ;
        List<String> list = new ArrayList<>() ;
        StringBuilder sb = new StringBuilder() ;
        row(sb, list, arr) ;

        int[][] dp = new int[n+1][list.size()+1] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        return ways(list,-1, n, dp) ;

    }
    void row(StringBuilder sb, List<String> list, char[] arr) {
        
        if(sb.length() == 3) {
            if(sb.charAt(1) != sb.charAt(0) && sb.charAt(1)!=sb.charAt(2)){
                list.add(sb.toString()) ;
                return ;
            }
            else return ;
        }

       for(int j= 0; j<3; j++ ) {
           sb.append(arr[j]) ;
           row(sb, list, arr) ;
           sb.setLength(sb.length()-1) ;
       }

    }
    int ways(List<String> list , int p, int n, int[][] dp) {
       
        if(n == 0) return 1 ;

        if(dp[n][p+1] != -1) return dp[n][p+1];
        int ans = 0;
        for(int i = 0; i<list.size(); i++) {
        if(p == -1 || (list.get(i).charAt(0) != list.get(p).charAt(0) && list.get(i).charAt(1) != list.get(p).charAt(1) && list.get(i).charAt(2) != list.get(p).charAt(2))) {
           ans += ways(list, i, n-1, dp) ;
           ans%=1000000007 ;
        }

        
       }
       return dp[n][p+1] = ans ;
}
}