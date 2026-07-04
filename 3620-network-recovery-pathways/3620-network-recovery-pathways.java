class Solution {
    class Node{
        int val ;
        int c ;
        Node(int val, int c){
            this.val = val; 
            this.c = c ;
        }
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>() ;
        for(int i = 0; i<online.length; i++) list.add(new ArrayList<>()) ;
        
        int maxcost = Integer.MIN_VALUE;
        int mincost = Integer.MAX_VALUE ;

        for(int i = 0; i<edges.length; i++){
            if(online[edges[i][0]] == false  || online[edges[i][1]] == false )
            continue ;

            list.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]) ) ;
            maxcost = Math.max(maxcost, edges[i][2]) ;
            mincost = Math.min(mincost, edges[i][2]) ;
        }
        int s = mincost;
        int e = maxcost ;
         int ans = -1 ;
        while(s<=e) {
            int mid = s + (e - s) / 2 ;
           
            if(check(mid, list, k)) {ans = mid; s = mid + 1 ;}
            else e = mid - 1;
        }
        return ans ;
    }
    boolean check(int mid, ArrayList<ArrayList<Node>> list, long k) {
        long[] dis = new long[list.size()] ;
       
        int[] vis = new int[list.size()] ;
        Arrays.fill(dis, Long.MAX_VALUE) ;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> {return Long.compare(a[0],b[0]) ;}) ;
        pq.add(new long[]{0,0}) ;
         dis[0] = 0 ;
        while(!pq.isEmpty()){
            long[] t = pq.remove() ;
            long cost = t[0] ;
            int node =(int) t[1] ;
            if(vis[node] == 1) continue ;
            if(cost > k) return false ;
            if(node == list.size()-1) return true ;
            vis[node] = 1;
            for(int i = 0; i<list.get(node).size(); i++){
                int c = list.get(node).get(i).c ;
                if(c < mid) continue ;
                if(dis[node] + c < dis[list.get(node).get(i).val]) {
                    dis[list.get(node).get(i).val] = dis[node] + c ;
                    pq.add(new long[]{dis[node] + c, list.get(node).get(i).val}) ;
                }

            }
        }
        return false ;
    }
}