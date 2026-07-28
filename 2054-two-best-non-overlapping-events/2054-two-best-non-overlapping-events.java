class Solution {
    public int maxTwoEvents(int[][] events) {
             int[][] dp = new int[events.length + 1][3] ;
        for(int[] ele: dp) Arrays.fill(ele, -1) ;
        Arrays.sort(events, (a,b) -> { return a[0] - b[0] ;}) ;

        return fun(events, 0, 2, dp) ;

    } 
    int fun (int[][] events, int i, int k, int[][] dp) {
        if(i == events.length || k == 0) return 0;

        if(dp[i][k] != -1) return dp[i][k] ;
        int nxt = bs(events, events[i][1]) ;
        int take = events[i][2] + fun(events, nxt, k-1, dp) ;
        int skip = fun(events, i + 1, k, dp) ;

        return dp[i][k] = Math.max(take, skip) ;
    }
    int bs(int[][] events, int t) {
        int s = 0; 
        int e = events.length-1; 
        int ans = events.length ;
        while(s <= e) {
            int mid = s+ (e - s) / 2 ;

            if(events[mid][0] > t) { ans = mid ; e = mid - 1;}
            else s = mid + 1 ;
        }
        return ans ;
    }      
    }
