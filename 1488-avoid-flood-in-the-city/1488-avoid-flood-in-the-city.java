class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> zd = new TreeSet<>() ;
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int[] ans = new int[rains.length] ;
        for(int i = 0; i<rains.length; i++) {
            if(rains[i] > 0) {
                if(!hm.containsKey(rains[i])) {
                    ans[i] = -1 ;
                    hm.put(rains[i], i) ;
                }
                else {
                    int zeroidx = fun(zd, hm.get(rains[i])) ;
                    if(zeroidx == -1) return new int[]{} ;
                    hm.put(rains[i] , i) ;
                    ans[zeroidx] = rains[i] ;
                    ans[i] = -1 ;

                }
            }
            else {
                zd.add(i) ;
            }
        }
        for(int i = 0; i<ans.length; i++) {if(ans[i] == 0) ans[i] = 1;}
        return ans ;
    }
    int fun(TreeSet<Integer> zd, int i) {
        Integer t = zd.higher(i) ;
        if(t == null) return -1;
        else{
            int temp = t;
            zd.remove(temp) ;
            return temp ;
        }
    }
}