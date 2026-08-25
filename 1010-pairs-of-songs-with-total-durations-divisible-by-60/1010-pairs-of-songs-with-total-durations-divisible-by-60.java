class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int c = 0;
        for(int i = 0; i<time.length; i++) {
            for(int j = 1; j<=20; j++) {
                int diff = j*60 - time[i] ;
                if(hm.containsKey(diff)) c+=hm.get(diff) ;
            }
            if(hm.containsKey(time[i])) hm.put(time[i], hm.get(time[i]) + 1) ;
            else hm.put(time[i], 1 ) ;
        }

        return c ;
    }
}