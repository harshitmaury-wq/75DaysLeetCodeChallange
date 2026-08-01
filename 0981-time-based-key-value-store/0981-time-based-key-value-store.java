class TimeMap {
   HashMap<String, ArrayList<pair>> hm ;
    class pair{
        String val;
        int ts;
        pair(int ts, String val) {
            this.ts = ts;
            this.val = val ;
        }
    }
    int bs (ArrayList<pair> list, int t) {
        int s = 0;
        int e = list.size() - 1;
        int ans = -1 ;
        while(s <= e ) {
            int mid = s + (e - s) /2 ;

            
            if(list.get(mid).ts > t) e = mid - 1;
            else {ans = mid ;s = mid + 1 ;}
        }
        return ans;
    }
    public TimeMap() {
        hm = new HashMap<>() ;
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)) hm.get(key).add(new pair(timestamp, value)) ;
        else {
            ArrayList<pair> list = new ArrayList<>() ;
            list.add(new pair (timestamp, value)) ;
            hm.put(key, list) ;
        }  
        
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "" ;
        if(hm.get(key).get(0).ts > timestamp) return "" ;


        int idx = bs(hm.get(key) , timestamp) ;
        return hm.get(key).get(idx).val ;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */