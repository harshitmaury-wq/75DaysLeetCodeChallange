class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] mod = new int[hours.length] ;
        for(int i = 0; i<hours.length; i++) mod[i] = hours[i]%24 ;

        HashMap<Integer, Integer> hm = new HashMap<>() ;
        long c = 0; 
        for(int i = 0; i<mod.length; i++) {
            int diff = 24 - mod[i];

            if(hm.containsKey(diff)) c+=(long)hm.get(diff) ;

            if(hm.containsKey(mod[i])) hm.put(mod[i], hm.get(mod[i]) +1) ;
            else hm.put(mod[i], 1) ;
        }

        if(hm.containsKey(0)) {
            long n = hm.get(0) ;
            if(n%2 == 0) {
                long t = n/2;

                c+=(1L*t*(n-1)) ;
            }
            else {
                long t = (n-1) / 2 ;
                c += (1L*t*n) ;
            }
        }
        return c ;
    }
}