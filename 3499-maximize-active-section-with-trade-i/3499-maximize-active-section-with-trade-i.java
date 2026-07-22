class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> list = new ArrayList<>() ;
        int c = 0;
        int one = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '1'){
                one++;
               if(c>0) list.add(c) ;
                c = 0;
            }
            else c++;
        }
        if(c >  0) list.add(c) ;
        int max = Integer.MIN_VALUE ;
        for(int i = 1; i<list.size(); i++) {
            max = Math.max(max, list.get(i) + list.get(i-1)) ;
            
        }
        if(max == Integer.MIN_VALUE || list.size() <= 1) return one ;
        return max + one;

    }

}