class Solution {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int[] st = new int[4*baskets.length] ;
        build(st, 0, baskets.length-1, 0, baskets) ;
        
        int c = 0;
        for(int i = 0; i<fruits.length; i++) {

            boolean b = findbasket(st, 0, baskets.length-1, fruits[i], 0) ;
            if(!b) c++;

        }
        return c ;
    }
    void build (int[]st, int s, int e , int i, int[] arr) {
        if(s == e) {st[i] = arr[s] ; return ; }

        int mid = s + (e - s) /2 ;

        build(st, s, mid, 2*i+1, arr) ;
        build(st, mid+1, e, 2*i+2, arr) ;

        st[i] = Math.max(st[2*i+1] , st[2*i+2]) ;
    }
    boolean findbasket (int[] st, int s, int e, int t, int i) {
        if(st[i] < t) return false;
        if(s == e) {st[i] = -1; return true ;} 

        int mid = s + (e - s) / 2 ;
        boolean b = false ;
        if(t <= st[2*i+1]) b = findbasket(st, s, mid, t, 2*i+1) ;
        else if(t <= st[2*i+2]) b = findbasket(st, mid + 1, e, t, 2*i+2) ;

        st[i] = Math.max(st[2*i + 1], st[2*i + 2]);

        
        return b ;
    }
}