class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        ArrayList<ArrayList<int[]>> list = new ArrayList<>() ;

        for(int i = 0; i<n; i++) list.add(new ArrayList<>()) ;

        for(int i = 0; i<edges.length; i++) {
            list.get(edges[i][0]).add(new int[]{edges[i][2], edges[i][1]}) ;
            list.get(edges[i][1]).add(new int[]{edges[i][2], edges[i][0]}) ;
        } 

        int[][] mat = new int[n][] ;

        for(int i = 0; i<mat.length; i++) {
            mat[i] = fun(list, i) ;
        }
        
        int ans = -1;
        int min = Integer.MAX_VALUE ;
        for(int i = 0; i<mat.length; i++) {
            int c = 0;
            for(int j = 0; j<mat[0].length; j++) {
                if(mat[i][j] <= dt) c++;
            }
            if(c <= min) {min = c; ans = i ;}
        }

        return ans ;
    }
    int[] fun(ArrayList<ArrayList<int[]>> list, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[0]-b[0] ;}) ;
        int[] dis = new int[list.size()] ;
        Arrays.fill(dis, Integer.MAX_VALUE) ;
        int[] vis= new int[list.size()] ;
        dis[src] = 0;
        pq.add(new int[]{0, src}) ;

        while(!pq.isEmpty()) {
            int[] arr = pq.remove() ;
            int d = arr[0] ;
            int node = arr[1] ;

            if(vis[node] == 1) continue ;

            vis[node] = 1;

            for(int i = 0; i<list.get(node).size(); i++) {
                if(vis[list.get(node).get(i)[1]] == 0 && dis[list.get(node).get(i)[1]] > list.get(node).get(i)[0] + d) {
                    dis[list.get(node).get(i)[1]] = list.get(node).get(i)[0] + d ;
                    pq.add(new int[]{ dis[list.get(node).get(i)[1]], list.get(node).get(i)[1]}) ;
                }
            }
        }
        return dis ;
    }
}