class Solution {
    int count = 0;
    public int maximumDetonation(int[][] bombs) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;

        for(int i = 0; i<bombs.length; i++) list.add(new ArrayList<>()) ;

        for(int i = 0; i<bombs.length; i++) {
            int x1 = bombs[i][0] ;
            int y1 = bombs[i][1] ;
            int r1 = bombs[i][2] ;
            for(int j = 0; j<bombs.length; j++) {
                if(i == j) continue ;

                int x2 = bombs[j][0] ;
                int y2 = bombs[j][1] ;
                int r2 = bombs[j][2] ;

                if(Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) <= r1 ){
                    list.get(i).add(j) ;
                } 
            }
        }
        int[] vis = new int[bombs.length] ;
        int max = 1;
        for(int i = 0; i<bombs.length; i++) {
            count = 0;
            Arrays.fill(vis, 0) ;
            dfs(list, i, vis) ;
            max = Math.max(max, count) ;
        }

        return max ;
        
    }
    void dfs (ArrayList<ArrayList<Integer>> list, int s, int[] vis ) {
        
        vis[s] = 1 ;
        count ++;
        for(int i = 0; i<list.get(s).size(); i++) {
            if(vis[list.get(s).get(i)] == 0) dfs(list, list.get(s).get(i), vis) ;
        }
    }
}