class Solution {
    public int minDays(int[] b, int m, int k) {
        
        int max = Integer.MIN_VALUE ;
        for(int x : b) max = Math.max(max, x) ;

        int s = 0; 
        int e = max ;
        int ans = -1 ;
        while(s <=e ) {
            int mid = s + (e - s) / 2 ;

            int c = 0;
            int t = 0;
            for(int i = 0 ; i<b.length; i++) {
                if(b[i] <= mid) {
                    t++; 
                    if(t == k) {
                        t = 0;
                        c++;
                    }
                }
                else {
                    t = 0; 
                }
            }

            if(c >= m) {ans = mid; e = mid - 1 ;} 
            else s = mid + 1 ;
        }

        return ans; 
    }
}