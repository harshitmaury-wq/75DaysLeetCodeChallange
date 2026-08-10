class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disap) {
        int[] dis = new int[n] ;
        Arrays.fill(dis, Integer.MAX_VALUE) ;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{return a[0]-b[0] ;}) ;

        ArrayList<ArrayList<int[]>> list = new ArrayList<>() ;
        for(int i = 0; i<n; i++) list.add(new ArrayList<>()) ;

        for(int i = 0; i<edges.length; i++) {
            list.get(edges[i][0]).add(new int[]{edges[i][2], edges[i][1]}) ;
            list.get(edges[i][1]).add(new int[]{edges[i][2], edges[i][0]}) ;
        }

        pq.add(new int[]{0,0}) ;
        dis[0] = 0 ;
        int[] vis = new int[n] ;

        while(!pq.isEmpty()) {
            int[] temp = pq.remove() ;
            int d = temp[0] ;
            int node = temp[1] ;

            if(vis[node] == 1) continue ;
            vis[node] = 1 ;

            for(int i = 0; i<list.get(node).size(); i++) {
                if(vis[list.get(node).get(i)[1]]==0 && d+list.get(node).get(i)[0] < dis[list.get(node).get(i)[1]] && d+list.get(node).get(i)[0] < disap[list.get(node).get(i)[1]]){
                    dis[list.get(node).get(i)[1]] = d+list.get(node).get(i)[0] ;
                    pq.add(new int[]{ dis[list.get(node).get(i)[1]], list.get(node).get(i)[1]}) ;
                }
            }
        }

        for(int i = 0; i<dis.length; i++) {
            if(dis[i] == Integer.MAX_VALUE ) dis[i] = -1 ;

        }

        return dis ;

    }
}