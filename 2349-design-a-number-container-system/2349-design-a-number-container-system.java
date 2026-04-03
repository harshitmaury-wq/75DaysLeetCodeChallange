class NumberContainers {
    HashMap<Integer, Integer> hm = new HashMap<>();
    HashMap<Integer, PriorityQueue<Integer>> tm = new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
       hm.put(index, number);
        if(tm.containsKey(number)) tm.get(number).add(index);
        else {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(index);
            tm.put(number, pq);
        }
    }
    
    public int find(int number) {
        if(!tm.containsKey(number) || tm.get(number).isEmpty()) return -1;
      while(!tm.get(number).isEmpty() && hm.get(tm.get(number).peek()) != number ) tm.get(number).remove();
         if(tm.get(number).isEmpty()) return -1;
         return tm.get(number).peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */