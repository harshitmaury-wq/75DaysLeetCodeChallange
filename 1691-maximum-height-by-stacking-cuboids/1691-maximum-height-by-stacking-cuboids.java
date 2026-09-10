class Solution {
    public int maxHeight(int[][] cuboids) {

        int[][] dp = new int[cuboids.length][cuboids.length+1] ;
        for(int[] ele : dp) Arrays.fill(ele, -1) ;

        for(int[] ele : cuboids) Arrays.sort(ele) ;

        Arrays.sort(cuboids, (a, b) -> {
        if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
        if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
        return Integer.compare(a[2], b[2]);
        });
        return fun(cuboids, cuboids.length-1, -1, dp) ;

    }
    int fun (int[][] cu, int s, int p, int[][] dp) {
        if(s<0) return 0;

        if(dp[s][p+1] != -1) return dp[s][p+1] ;
        if(p ==-1 || (cu[p][0] >= cu[s][0] && cu[p][1] >= cu[s][1] && cu[p][2] >= cu[s][2])){
            int take = cu[s][2] + fun(cu, s-1, s, dp) ;
            int skip = fun(cu, s-1, p, dp);
            return dp[s][p+1] = Math.max(take, skip) ;
        }
        else {
            return dp[s][p+1]= fun(cu, s-1, p, dp) ;
        }
    }
}