class Solution {
    public int findCircleNum(int[][] isConnected) {

       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       int n = isConnected.length + 1 ;

        for(int i=0; i<n; i++) adj.add(new ArrayList<>()) ;

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected.length; j++){
                if(i==j) continue ;
                if(isConnected[i][j] == 1) adj.get(i+1).add(j+1) ;
            }
        }

        int[] visi = new int[n] ;

        int count = 0;
        for(int i=1; i<n ; i++){
            
            if(visi[i] == 0){
                count++;
                dfs(i, adj, visi) ;
            }
        }
        return count ;
        
    }
    static void dfs (int s,  ArrayList<ArrayList<Integer>> adj, int[] visi) {
        if(s >= adj.size()) return;

        visi[s] = 1;
        for(int i=0; i<adj.get(s).size(); i++){
            if(visi[adj.get(s).get(i)] == 0) dfs(adj.get(s).get(i) , adj, visi) ;    
        }
    }
}