class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length] ;
        for(int[] ele: dp) Arrays.fill(ele, Integer.MIN_VALUE) ;

        return fun(dungeon, 0, 0, dp) ;
    }
    int fun(int[][] dun , int x, int y, int[][] dp){
        if(x == dun.length-1 && y == dun[0].length-1){
            if(dun[x][y] < 0)  return dp[x][y]= Math.abs(dun[x][y]) + 1 ;
            else return dp[x][y]=1 ;
        } 
        if(x >= dun.length || y>=dun[0].length || x<0 || y < 0) return Integer.MAX_VALUE ;

        if(dp[x][y] != Integer.MIN_VALUE) return dp[x][y] ;
        int right = fun(dun, x+1, y, dp) ;
        int down = fun(dun, x, y+1,dp) ;
        int res = Math.min(right, down  ) - dun[x][y] ;

        if(res <= 0 ) return dp[x][y] = 1 ;
        else return dp[x][y] = res ;

    }
}