class Solution {
    int v = 0;
    int e = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>() ;
        for(int i = 0; i<n; i++) list.add(new ArrayList<>()) ;
        for(int i = 0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]) ;
            list.get(edges[i][1]).add(edges[i][0]) ;
        }
        int[] vis = new int[n] ;
        int ans = 0;
        for(int i = 0; i<vis.length; i++){
            if(vis[i] == 0){
                dfs(vis, list , i) ;
                e = e/2;
                if((v*(v-1))/2 == e) ans ++;
                v = 0;
                e = 0;
                
            }
            
        }
        return ans ;
    }
    void dfs (int[] vis, List<List<Integer>> list, int s) {
        
        vis[s] = 1;
        v++;
        e+=(list.get(s).size()) ;
        for(int i = 0; i<list.get(s).size(); i++){
            if(vis[list.get(s).get(i)] == 0) dfs(vis, list, list.get(s).get(i)) ;
        }
        
    }
}