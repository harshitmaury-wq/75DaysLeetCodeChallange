class Solution {
    public int makeConnected(int n, int[][] con) {
        if(con.length < n-1) return -1;

        int c = n ;

        int[] par = new int[n] ;
        int[] rank = new int[n] ;
        for(int i = 0; i<par.length; i++) par[i] = i ;


        for(int i = 0; i<con.length; i++) {
            int a = con[i][0] ;
            int b = con[i][1] ;

            int par_a = ultimate_parent(par, a);
            int par_b = ultimate_parent(par, b) ;

            if(par_a == par_b) continue ;

            c--;
            if(rank[par_a] > rank[par_b]) {
                par[par_b] = par_a ;
            }
            else if(rank[par_a] < rank[par_b]) {
                par[par_a] = par_b ;
            }
            else {
                par[par_a] = par_b ;
                rank[par[par_a]] ++ ;
            }

        }

        return c - 1 ;

    }
    int ultimate_parent(int[] par, int s) {
        if(par[s] == s) return s;

        return par[s] = ultimate_parent(par, par[s]) ;
    }
}