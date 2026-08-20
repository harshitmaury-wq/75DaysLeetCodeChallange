class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>() ;

        for(int i = 0; i<rs.length; i++) {

            if(hm.containsKey(rs[i][0])) hm.get(rs[i][0]).add(rs[i][1]) ;
            else {
                HashSet<Integer> hs = new HashSet<>() ;
                hs.add(rs[i][1]) ;
                hm.put(rs[i][0], hs) ;
            }

            
        }

        int grps= 0;
        for(Integer i : hm.keySet()) {
            boolean a = false ;
            boolean b = false ;
            HashSet<Integer> hs= hm.get(i) ;

            if(!(hs.contains(2) || hs.contains(3) || hs.contains(4) || hs.contains(5) )) {grps++; a = true; }

            if(!(hs.contains(4) || hs.contains(5) || hs.contains(6) || hs.contains(7) ) && !a) {grps++; b = true; }

            if(!(hs.contains(6) || hs.contains(7) || hs.contains(8) || hs.contains(9) ) && !b) grps++;
        }

        int remaining = n - hm.size() ;

        grps += (remaining * 2) ;

        return grps;
    }
}