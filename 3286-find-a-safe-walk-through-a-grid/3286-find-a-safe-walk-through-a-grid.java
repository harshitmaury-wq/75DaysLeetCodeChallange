class Solution {
    public boolean findSafeWalk(List<List<Integer>> list, int health) {
        int m = list.size();
        int n = list.get(0).size(); 
        int[][] dis = new int[m][n] ;
        for(int[]ele : dis) Arrays.fill(ele, Integer.MAX_VALUE) ;
        int[][] vis = new int[m][n] ;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[0] - b[0] ; }) ;

        dis[0][0] = list.get(0).get(0) ;
       
        

        pq.add(new int[]{list.get(0).get(0), 0, 0}) ;

        while(!pq.isEmpty()) {
            int[] temp = pq.remove() ;
            int r = temp[1] ;
            int c = temp[2] ;
            int cost = temp[0] ;

            
            if(vis[r][c] == 1) continue ;

            vis[r][c] = 1;

            if(r+1 < m && dis[r][c] + list.get(r+1).get(c) < dis[r+1][c]){
                dis[r+1][c] = dis[r][c] + list.get(r+1).get(c) ;
                pq.add(new int[]{dis[r+1][c], r+1, c}) ;
            }
            if(r-1 >=0 && dis[r][c] + list.get(r-1).get(c) < dis[r-1][c]){
                dis[r-1][c] = dis[r][c] + list.get(r-1).get(c) ;
                 pq.add(new int[]{dis[r-1][c], r-1, c}) ;
            }
            if(c+1 < n && dis[r][c] + list.get(r).get(c+1) < dis[r][c+1]){
                dis[r][c+1] = dis[r][c] + list.get(r).get(c+1) ;
                 pq.add(new int[]{dis[r][c+1], r, c+1}) ;
            }
            if(c-1 >= 0 && dis[r][c] + list.get(r).get(c-1) < dis[r][c-1]){
                dis[r][c-1] = dis[r][c] + list.get(r).get(c-1) ;
                 pq.add(new int[]{dis[r][c-1], r, c-1}) ;
            }
            
        }

        if(health - dis[m-1][n-1] >= 1) return true;
        return false ;
    }
}