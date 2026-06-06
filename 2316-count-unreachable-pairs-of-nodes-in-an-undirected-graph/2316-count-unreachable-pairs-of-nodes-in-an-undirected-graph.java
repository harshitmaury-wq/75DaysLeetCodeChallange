class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;

        for(int i = 0; i<n; i++) list.add(new ArrayList<>()) ;

        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]) ;
             
            list.get(edges[i][1]).add(edges[i][0]) ;
        }


        int[] vis = new int[n] ;
        long ans = 1L*n*(n-1)/2;
        for(int i=0; i<vis.length; i++){
            if(vis[i] == 0){
                long c = dfs(list, i, vis);
                ans -= 1L*(c*(c-1)/2) ;

            }
            
        }
        return ans ;

    }
    long dfs(ArrayList<ArrayList<Integer>> list, int s, int[] vis){
        vis[s] = 1;
        long c = 1;
        for(int i = 0; i<list.get(s).size(); i++){
            if(vis[list.get(s).get(i)]==0) {
                c +=  dfs(list, list.get(s).get(i), vis) ;
            }
        }
        return c ;
    }
}