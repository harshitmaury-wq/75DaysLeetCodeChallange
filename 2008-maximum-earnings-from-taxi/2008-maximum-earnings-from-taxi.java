class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[rides.length + 1] ;
        Arrays.fill(dp, -1) ;
        Arrays.sort(rides, (a,b) -> {return a[0] - b[0] ;}) ;

        return fun (rides, 0, dp) ;
    }
    long fun (int[][] rides, int i, long[] dp ) {
        if(i == rides.length) return 0 ;

        if(dp[i] != -1) return dp[i] ;
        int nxt = bs(rides, rides[i][1]) ;

        long take = rides[i][1] - rides[i][0] + rides[i][2]+ fun(rides, nxt, dp) ;
        long skip = fun(rides, i+1, dp) ; 

        return dp[i] = Math.max(take, skip) ;

    }
    int bs (int[][] arr, int t) {
        int s = 0; 
        int e = arr.length -1 ;
        int ans = arr.length ;
        while(s <= e) {
            int mid = s + (e - s) / 2 ;

            if(arr[mid][0] >= t) {ans = mid ; e = mid -1 ; } 

            else s = mid + 1 ;
        }
        return ans ;
    }
}