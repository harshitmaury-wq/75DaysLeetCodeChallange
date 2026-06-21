class MyCalendarThree {
    TreeMap<Integer, Integer> ts = new TreeMap<>() ;
    public MyCalendarThree() {
        
    }
    
    public int book(int startTime, int endTime) {
        if(ts.containsKey(startTime)) ts.put(startTime, ts.get(startTime) + 1) ;
        else ts.put(startTime, 1) ;

        if(ts.containsKey(endTime)) ts.put(endTime, ts.get(endTime) - 1) ;
        else ts.put(endTime, -1) ;

        int c = 0;
        int k = 1 ;
        for(Integer i : ts.keySet()){
            c+=ts.get(i) ;
            
            k = Math.max(k, c) ;

        }
        return k ;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */