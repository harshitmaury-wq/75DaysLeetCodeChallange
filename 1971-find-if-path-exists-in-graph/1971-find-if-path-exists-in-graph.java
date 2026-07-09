class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>() ;
        for(int i = 0; i<n; i++) list.add(new ArrayList<>()) ;
        
        for(int i = 0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]) ;
             list.get(edges[i][1]).add(edges[i][0]) ;
        }
        int[] vis = new int[n] ;
        dfs(list, vis, source) ;
        if(vis[destination] == 1) return true;
        return false ;
    }
    void dfs(List<List<Integer>> list, int[] vis, int s){
        vis[s] = 1;
        for(int i = 0; i<list.get(s).size(); i++){
            if(vis[list.get(s).get(i)] == 0) {
                dfs(list, vis, list.get(s).get(i)) ;
            }
        }
    }
}