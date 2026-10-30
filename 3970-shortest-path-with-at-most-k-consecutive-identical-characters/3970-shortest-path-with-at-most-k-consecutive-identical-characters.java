class Solution {
    class Node{
        int val ;
        int dis;
        char c;
        int maxconse;
        Node(int val, int dis, char c, int maxconse) {
            this.val = val ;
            this.dis = dis ;
            this.c = c;
            this.maxconse = maxconse ;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        
        List<List<int[]>> list = new ArrayList<>() ;
        for(int i = 0; i<n ; i++) list.add(new ArrayList<>()) ;

        for(int i = 0; i<edges.length; i++) {
            list.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
        }

        int[][] distance = new int[n][k + 1] ;
        for(int[] ele : distance ) Arrays.fill(ele, Integer.MAX_VALUE);
        distance[0][1] = 0 ;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {return a.dis - b.dis;}) ;
        pq.add(new Node(0, 0, labels.charAt(0), 1)) ;

        while(!pq.isEmpty()) {
            Node temp = pq.remove() ;

            int ch = temp.c ;
            int node = temp.val;
            int max= temp.maxconse;
            int d = temp.dis ;

            for(int i =0 ; i<list.get(node).size(); i++) {

                int neigh = list.get(node).get(i)[0] ;
                int neighw = list.get(node).get(i)[1] ;

                int currstreak;
                if(labels.charAt(neigh) == ch) currstreak = max+1 ;
                else currstreak = 1 ;
                
                if(currstreak > k) continue ;

                if((long)(d + neighw) < distance[neigh][currstreak] ) {
                    distance[neigh][currstreak] = d + neighw;
                    pq.add(new Node(neigh, distance[neigh][currstreak], labels.charAt(neigh), currstreak)) ;
                }
            }
        }

        int min = Integer.MAX_VALUE ;

        for(int x : distance[n-1]) min = Math.min(min, x) ;

        if(min == Integer.MAX_VALUE) return -1 ;
        else  return min ;
    }
}