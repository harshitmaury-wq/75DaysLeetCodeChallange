class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<events.length; i++){
            list.add(events[i]);
        }
        Collections.sort(list, (a,b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return 1;
            else {
                if(a[1] < b[1]) return -1;
                else if(a[1] > b[1]) return 1;
                else return 0;
            }
        });
        int day = list.get(0)[0];
        int count = 0;
        int i=0;
        while(i<events.length || !pq.isEmpty()){
            while(i<events.length && day == list.get(i)[0]) {
                pq.add(list.get(i)[1]) ; 
                i++ ;}

            if(!pq.isEmpty()){
                pq.remove();
                count++;
            }
            day++;

            while(!pq.isEmpty() && day > pq.peek()) pq.remove();
        }
        return count ;
    }
}