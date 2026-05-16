class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()) ;
    PriorityQueue<Integer> min = new PriorityQueue<>() ;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

        if(max.isEmpty()) { max.add(num); return; }

        if(num > max.peek()) min.add(num);
        else max.add(num) ;

        if(min.size() > max.size() ) max.add(min.remove()) ;
        if(max.size() > min.size() + 1) min.add(max.remove()) ;
        
    }
    
    public double findMedian() {

        if(max.size() == min.size()) {
            return (double) (max.peek()+min.peek())/2.0 ;
        }

        else return (double) max.peek() ;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */