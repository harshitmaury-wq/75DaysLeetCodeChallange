class Solution {
    public int removeStones(int[][] stones) {
        
        int[] par = new int[stones.length] ;
        for(int i = 0; i<par.length; i++) par[i] = i ;

        int[] rank = new int[stones.length] ;

        for(int i = 0; i<stones.length; i++) {
            for(int j = i+1; j<stones.length; j++) {

                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){

                    int ulti_par_i = ulti_par( par, i ) ;
                    int ulti_par_j = ulti_par( par, j ) ;

                    if(ulti_par_i == ulti_par_j) continue ;

                    if(rank[ulti_par_i] > rank[ulti_par_j]) {
                        par[ulti_par_j] = ulti_par_i ;
                    }
                    else if(rank[ulti_par_i] < rank[ulti_par_j]) {
                        par[ulti_par_i] = ulti_par_j ;
                    }
                    else {
                        par[ulti_par_j] = ulti_par_i ;
                        rank[ulti_par_i] ++ ;
                    }
                }

            }
        }

        int c = 0;
        int last = -1 ;
        for( int i = 0; i<par.length; i++ ) {
            if(par[i] == i) c++;
        }
            return stones.length - c ;

    }
    int ulti_par(int[] par, int s) {
        if(par[s] == s) return s ;

        return par[s] = ulti_par(par, par[s]) ;
    }
}