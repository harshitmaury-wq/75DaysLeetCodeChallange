class Solution {
    class Node{
        int val;
        int w;
        Node(int val, int w){
            this.val = val;
            this.w = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>() ;
        for(int i=0; i<n+1; i++) list.add(new ArrayList<>());

        for(int i=0; i<times.length; i++){
            list.get(times[i][0]).add(new Node(times[i][1], times[i][2])) ;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> { return a.w - b.w ; }) ;
        int[] dis = new int[n+1] ;
        Arrays.fill(dis, Integer.MAX_VALUE) ;

        dis[k]  = 0;
        pq.add(new Node(k, 0));

        while(!pq.isEmpty()) {
            Node temp = pq.remove() ;
            int val = temp.val;
            int w = temp.w ;

            for(int i=0; i<list.get(val).size(); i++){
                if(w + list.get(val).get(i).w < dis[list.get(val).get(i).val]){
                    dis[list.get(val).get(i).val] = w + list.get(val).get(i).w ;
                    pq.add(new Node(list.get(val).get(i).val, dis[list.get(val).get(i).val]));
                }
            }
        } 
        int max = Integer.MIN_VALUE;
        for(int i=1; i<dis.length; i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(dis[i], max) ;
        }
        return max;
    }
}