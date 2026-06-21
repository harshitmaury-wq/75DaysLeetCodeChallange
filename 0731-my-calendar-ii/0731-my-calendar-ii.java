class MyCalendarTwo {
    TreeMap<Integer, Integer> ts=  new TreeMap<>() ;
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int startTime, int endTime) {
        if(ts.containsKey(startTime)) ts.put(startTime, ts.get(startTime) + 1) ;
        else ts.put(startTime, 1) ;

        if(ts.containsKey(endTime)) ts.put(endTime, ts.get(endTime) - 1) ;
        else ts.put(endTime, -1) ;

        int c = 0;
        for(Integer i : ts.keySet()){
            c+=ts.get(i) ;
            if(c>=3) {
                ts.put(startTime, ts.get(startTime) - 1) ;
                if(ts.get(startTime) == 0) ts.remove(startTime) ;

                ts.put(endTime, ts.get(endTime) + 1) ;
                if(ts.get(endTime) == 0) ts.remove(endTime) ;

                return false ;
            }

        }
        return true ;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */