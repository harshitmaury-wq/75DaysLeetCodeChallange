class Solution {
    class Node{
        int val;
        int cost ;
        Node(int val, int cost){
            this.cost = cost;
            this.val = val ;
        }
    }
    int min = Integer.MAX_VALUE ;
    public int minScore(int n, int[][] roads) {
        List<List<Node>> list = new ArrayList<>() ;
        int[] vis = new int[n+1] ;
        Arrays.fill(vis, -1) ;
        for(int i = 0; i<=n ; i++) list.add(new ArrayList<>()) ;
        for(int i = 0; i<roads.length; i++){
            list.get(roads[i][0]).add(new Node(roads[i][1], roads[i][2])) ;
            list.get(roads[i][1]).add(new Node(roads[i][0], roads[i][2])) ;
        }
        
                dfs(list, 1 , vis) ;
            
           
        
        return min ;
    }
    void dfs (List<List<Node>> list, int s, int[] vis){
        vis[s] = 1;

        for(int i = 0; i<list.get(s).size(); i++){
            int val = list.get(s).get(i).val ;
             
            int cost = list.get(s).get(i).cost ;
             min = Math.min(min, cost) ;
            if(vis[val] == -1) {
              
                dfs(list, val, vis) ;
            }
        }
        
    }
}