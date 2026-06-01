class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;
        for(int i = cost.length - 1; i>=0; i--){
            pq.add(cost[i]) ;
        }
        int i = 1;
        int sum = 0;
        while(!pq.isEmpty()){
            if(i%3==0) {pq.remove(); i++; }
            else {
                sum+=pq.remove() ;
                i++;
            }
        }
        return sum ;
    }
}