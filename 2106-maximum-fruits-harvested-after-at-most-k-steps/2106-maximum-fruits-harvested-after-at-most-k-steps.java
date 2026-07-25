class Solution {
    public int maxTotalFruits(int[][] fruits, int sp, int k) {
        int[] pre = new int[fruits.length] ;
        pre[0] = fruits[0][1] ;
        for(int i = 1; i<fruits.length; i++) pre[i] = fruits[i][1] + pre[i-1] ;
        int ans = 0;

        for(int i = 0; i<=k/2; i++ ) {
            int c1l = sp - i ;
            int c1r = sp + (k - 2*i) ;

            int l = lb(fruits, c1l) ;
            int r = ub(fruits, c1r) ;
            
            if (!(l == -1 || r == -1 || l > r))
            ans = Math.max(ans, pre[r] - (l==0 ? 0 : pre[l-1])) ;

            int c2l = sp - (k - 2*i) ;
            int c2r =  sp + i ;

             l = lb(fruits, c2l) ;
             r = ub(fruits, c2r) ;
            if (l == -1 || r == -1 || l > r)
            continue;
            
            ans = Math.max(ans, pre[r] - (l==0 ? 0 : pre[l-1])) ;
        }
        return ans ;
    }
    int lb (int[][] fruits, int t) {
        int s = 0; 
        int e = fruits.length - 1;
        int ans = -1 ;
        while(s<=e) {
            int mid = s + (e - s) / 2 ;

            if(fruits[mid][0] < t) s = mid + 1;
            else {
                ans = mid;
                e = mid - 1;
            }
        }
        return ans ;
    }

    int ub (int[][] fruits, int t) {
        int s = 0; 
        int e = fruits.length - 1;
        int ans = -1 ;
        while(s<=e) {
            int mid = s + (e - s) / 2 ;

            if(fruits[mid][0] > t) e = mid - 1;
            else {
                ans = mid;
                s = mid + 1 ;
            }
        }
        return ans ;
    }
    
}