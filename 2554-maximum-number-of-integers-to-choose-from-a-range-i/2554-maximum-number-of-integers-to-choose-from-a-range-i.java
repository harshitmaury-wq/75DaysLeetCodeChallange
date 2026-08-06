class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int c = 0;
        int[] ban = new int[10001] ;
        for(int i = 0; i<banned.length; i++) {
            ban[banned[i]] = 1 ;
        }
        int ms = 0;
        for(int i = 1; i<=n; i++) {
            
            if(ms > maxSum) break ;
            if(ban[i] == 0 && ms + i <= maxSum) {ms+=i ;c++;}
        }
        return c;
    }
}