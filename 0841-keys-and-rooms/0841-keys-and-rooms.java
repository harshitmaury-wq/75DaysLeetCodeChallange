class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size() ;

        int[] vis = new int[n] ;
        vis[0] =1 ;
        dfs(vis, rooms, 0) ;

        for(int i = 0; i<n; i++) {
            if(vis[i] == 0) return false ;
        }

        return true ;

    }   
    void dfs(int[] vis, List<List<Integer>> rooms, int s) {


        for(int i = 0; i<rooms.get(s).size(); i++) {
            int next = rooms.get(s).get(i) ;

            if(vis[next] == 0) {
                vis[next] = 1;
                dfs(vis, rooms, next) ;
            }
        }
    }
}