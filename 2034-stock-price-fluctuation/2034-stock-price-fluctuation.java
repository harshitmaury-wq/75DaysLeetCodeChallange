class StockPrice {
    HashMap<Integer, Integer> hm ;
    PriorityQueue<int[]> min ;
    PriorityQueue<int[]> max ;
    int latesttime;
    
    public StockPrice() {
        hm = new HashMap<>() ;
        min = new PriorityQueue<>((a,b) -> {return a[1]-b[1] ;}) ;
        max = new PriorityQueue<>((a,b) -> {return b[1]-a[1] ;}) ;
    }
    
    public void update(int timestamp, int price) {
        if(hm.containsKey(timestamp)) {hm.put(timestamp, price) ;
        min.add(new int[]{timestamp, price}) ;
        max.add(new int[]{timestamp, price}) ; 
        }
        else {
             hm.put(timestamp, price) ;
             
              min.add(new int[]{timestamp, price}) ;
              max.add(new int[]{timestamp, price}) ; 
             
        }

      latesttime = Math.max(timestamp, latesttime) ;
    }
    
    public int current() {
        return hm.get(latesttime) ;
    }
    
    public int maximum() {
        while(max.peek()[1] != hm.get(max.peek()[0])) max.remove() ;
       return max.peek()[1] ;
    }
    
    public int minimum() {
         while(min.peek()[1] != hm.get(min.peek()[0])) min.remove() ;
         return min.peek()[1] ;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */