class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> q= new LinkedList<>() ;
        int[] dis = new int[n] ;
        Arrays.fill(dis, Integer.MAX_VALUE ) ;

        dis[src] = 0;

        ArrayList<ArrayList<int[]>> list = new ArrayList<>() ;
        for(int i =0; i<n; i++) list.add(new ArrayList<>() ) ;

        for(int i = 0; i<flights.length; i++) {
            list.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]}) ;
        }

        // stops, node, distance
        // BFS, since stops will increase only by 1 at every level
        q.add(new int[]{0,src,0} ) ;

        while(!q.isEmpty() ) {
            int[] temp = q.remove() ;

            int node = temp[1] ;
            int d = temp[2] ;
            int stops = temp[0] ;

            if(stops == k+1) break ;

            for(int i = 0; i<list.get(node).size(); i++) {

                if(list.get(node).get(i)[1] + d < dis[list.get(node).get(i)[0]] ) {
                    dis[list.get(node).get(i)[0]] = list.get(node).get(i)[1] + d ;
                    q.add(new int[]{stops+1, list.get(node).get(i)[0],  dis[list.get(node).get(i)[0]]}) ;
                }
            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst] ;

    }
}