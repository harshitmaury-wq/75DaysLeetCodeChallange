class Solution {
    char[] color = {'R', 'G', 'B'} ;
    public int colorTheGrid(int m, int n) {
        ArrayList<String> list = new ArrayList<>() ;
        StringBuilder sb = new StringBuilder() ;

        cols(list, sb, m, -1) ;

        int[][] dp = new int[list.size() + 1][n+1] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        return fun(list, 0, n , -1 , dp) ;

    }
    void cols(ArrayList<String> list, StringBuilder sb ,int m, int last) {
        if(sb.length() == m) {
            list.add(sb.toString()) ;
            return ;
        }

        for(int i = 0; i<3; i++) {
            if(i == last) continue ;
            sb.append(color[i]) ;
            cols(list, sb, m, i) ;
            sb.setLength(sb.length()-1) ;
        }
    }
    int fun (ArrayList<String> cols, int s, int n, int last, int[][] dp) {
        if(s == n) return 1 ; 

        if(dp[last+1][s] != -1) return dp[last+1][s] ;
        int c = 0;
        for(int i = 0; i<cols.size(); i++) {
            if(last == i) continue ;
            boolean b = false ;
            for(int j = 0; j<cols.get(i).length(); j++) {
                if(last == -1) break ;
                if(cols.get(i).charAt(j) == cols.get(last).charAt(j)) {b = true; break;}
            }

            if(b) continue;

            c += fun(cols, s+1, n, i, dp) ;
            c%=1000000007;
        }
        return dp[last+1][s] = c ;
    }

}