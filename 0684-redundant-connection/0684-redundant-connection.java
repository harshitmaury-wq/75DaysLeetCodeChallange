class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1] ;
        for(int i = 1; i<n+1; i++) par[i] = par[i-1] + 1;
        int[] rank = new int[n+1] ;

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0] ;
            int v = edges[i][1] ;

            int pu = findpar(u, par) ;
            int pv = findpar(v, par) ;
            if(pu == pv) return edges[i] ;
            
            if(rank[pu] < rank[pv]) par[pu] = pv ;
            else if(rank[pu] > rank[pv]) par[pv] = pu ;
            else {
                par[pv] = pu;
                rank[pu]++;
            }
        }
        return new int[]{0,0} ;
    }
    int findpar(int u, int[] par){
        if(par[u] == u) return u;

        return par[u] = findpar(par[u], par) ;
    }
}