class EventManager {
   HashMap<Integer, Integer> hm = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1]>b[1]) return -1;
            else if(a[1]<b[1]) return 1;
            else {
                if(a[0]<b[0]) return -1;
                else if(a[0]>b[0]) return 1;
                else return 0;
            }
            
        });
    
    public EventManager(int[][] events) {
        for(int i=0; i<events.length; i++){
           pq.add(events[i]) ;
           hm.put(events[i][0], events[i][1]);
        }
        
       
    }
    
    public void updatePriority(int eventId, int newPriority) {
      hm.put(eventId, newPriority);
      int[] n =new int[2];
      n[0] = eventId;
      n[1] = newPriority; 
         pq.add(n);
    }
    
    public int pollHighest() {
    if(pq.isEmpty()) return -1;
    while (!pq.isEmpty()) {
    int[] top = pq.peek();

    if (!hm.containsKey(top[0]) || top[1] != hm.get(top[0])) {
        pq.poll(); 
    } else {
        break;
    }
    }
        if(pq.isEmpty()) return -1;
       hm.remove(pq.peek()[0]);
       return pq.remove()[0];
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */