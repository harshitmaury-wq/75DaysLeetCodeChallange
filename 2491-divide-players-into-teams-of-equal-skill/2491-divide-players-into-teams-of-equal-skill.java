class Solution {
    public long dividePlayers(int[] skill) {
        long sum = 0;
        for(int i : skill) sum+=i ;

        

        int teams = skill.length / 2 ;

        if(sum % teams != 0) return  -1 ;

        long teamsum = sum / teams ;

        HashMap<Long, Integer> hm = new HashMap<>() ;

        long chem = 0 ;
        int c = 0 ;
        for(int i = 0; i<skill.length; i++) {
            long diff = teamsum - skill[i] ;
            if(hm.containsKey(diff)) {
                hm.put(diff, hm.get(diff) - 1) ;
                if(hm.get(diff) == 0) hm.remove(diff) ;
                long pro = 1L*diff*skill[i] ;
                chem += pro ;
                c++ ;
                continue ;
            }

            if(hm.containsKey((long)skill[i])) hm.put((long)skill[i], hm.get((long)skill[i]) + 1) ;
            else hm.put((long)skill[i] ,  1) ; 
        }

        return ( c != teams) ? -1 : chem ;
    }
}