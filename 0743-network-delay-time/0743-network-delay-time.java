class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>() ;

        for(int i = 0; i<n+1 ; i++) {
            list.add(new ArrayList<>()) ;
        }

        for(int i = 0; i<times.length ;i++) {
            list.get(times[i][0]).add(new int[]{times[i][1], times[i][2]}) ;
        }

        int[] dis= new int[n+1] ;
        Arrays.fill(dis, Integer.MAX_VALUE ) ;
        dis[k] = 0 ;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[0]-b[0];}) ;
        pq.add(new int[]{0,k}) ;

        while(!pq.isEmpty()) {
            int[] temp = pq.remove() ;
            int d = temp[0] ;
            int node = temp[1] ;

            if(dis[node] < d) continue ;

            for(int i= 0 ; i<list.get(node).size(); i++) {
                int next = list.get(node).get(i)[0] ;
                int wei = list.get(node).get(i)[1] ;
                
                if(d + wei < dis[next]) {
                    dis[next] = d + wei;
                    pq.add(new int[]{dis[next] , next}) ;
                }
            }
        }

        int max = Integer.MIN_VALUE ;

        for(int i = 1; i<dis.length; i++) {
            if(dis[i] == Integer.MAX_VALUE) return -1;

            max = Math.max(max, dis[i]) ;
        }

        return max;
    }
}