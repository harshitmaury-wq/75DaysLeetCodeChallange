class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] dp = new int[ages.length + 1][ages.length+2] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        ArrayList<int[]> list = new ArrayList<>() ;
        for(int i = 0; i<ages.length; i++) list.add(new int[]{ages[i], scores[i]}) ;
        Collections.sort(list, (a, b) -> {
        if (a[0] != b[0])
        return a[0] - b[0];
     return a[1] - b[1];
      });
        return fun(list, 0, -1, dp) ;

    }
    int fun (ArrayList<int[]> list, int i, int last, int[][]dp) {
        if(i == list.size()) return 0 ;

        if(dp[i][last+1] != -1) return dp[i][last+1] ;

        if(last == -1 || list.get(last)[1] <= list.get(i)[1] || list.get(last)[0]==list.get(i)[0]){
        int take = list.get(i)[1] + fun(list, i+1, i, dp) ;
        int skip = fun(list, i+1, last, dp) ;
        return dp[i][last+1] = Math.max(take, skip) ;
        }

        else return dp[i][last+1] = fun(list, i+1, last, dp) ;

    }
}