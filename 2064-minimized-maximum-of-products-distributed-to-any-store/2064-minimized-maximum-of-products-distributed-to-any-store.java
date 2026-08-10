class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int max = Integer.MIN_VALUE ;

        for(int i = 0; i<q.length; i++) {
            max = Math.max(max, q[i]) ;
        }

        int s = 1; 
        int e = max;
        int ans = -1 ;
        while(s<=e) {
            int mid = s+(e - s) / 2 ;

            int stores = 0;
            for(int i = 0; i<q.length; i++) {
                if(q[i] % mid == 0) stores+=(q[i]/mid) ;
                else stores+=(q[i]/mid + 1) ;
            }
            if(stores > n) s = mid + 1;
            else {ans = mid ; e = mid - 1 ;}
        }

        return ans ;
    }
}