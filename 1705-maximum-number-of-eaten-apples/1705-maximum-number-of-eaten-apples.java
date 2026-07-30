class Solution {
    public int eatenApples(int[] apple, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {return a[0]-b[0] ; } ) ;

       
        int ans = 0;
        int i = 0;
        for( i= 0 ; i<apple.length; i++) {
            while(!pq.isEmpty() && pq.peek()[0]<=i) pq.remove() ;

            if(days[i] != 0)pq.add(new int[]{i+days[i], apple[i]}) ;
            if(!pq.isEmpty() ) {
                ans ++;
                pq.peek()[1]-- ;
                if(pq.peek()[1] == 0) pq.remove() ;
            }

            
        }

        while(!pq.isEmpty()) {
            while(!pq.isEmpty() && pq.peek()[0]<=i)pq.remove() ;
            if(!pq.isEmpty() ) {
                ans ++;
                pq.peek()[1]-- ;
                if(pq.peek()[1] == 0) pq.remove() ;
            }
            i++;

        }
        return ans ;
    }
}