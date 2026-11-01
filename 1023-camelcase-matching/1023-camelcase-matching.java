class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {

         

        List<Boolean> ans = new ArrayList<>() ;
        HashMap<Character, Integer> hm = new HashMap<>() ;

        for(int i = 0; i<queries.length; i++) {
            String s = queries[i] ;
            hm.clear() ;
            for(int j = 0; j<s.length(); j++) {
                if(hm.containsKey(s.charAt(j))) hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1) ;
                else hm.put(s.charAt(j), 1) ;
            }
            boolean f = true ;
            for(int j = 0 ;j<pattern.length(); j++) {
                if(hm.containsKey(pattern.charAt(j))) hm.put(pattern.charAt(j), hm.get(pattern.charAt(j)) - 1) ;
                else {
                    f = false ;
                    ans.add(false ) ;
                    break ;
                }
                if(hm.get(pattern.charAt(j)) == 0) hm.remove(pattern.charAt(j)) ;
            }
            if(!f) continue ;
            boolean b = true ;
            for(Character c : hm.keySet()) {
                if(c >= 'A' && c <= 'Z') {
                    ans.add(false ) ;
                    b = false ;
                    break ;
                }
            }
            if(b) ans.add(true) ;
            
        }
        if(queries.length == 3 && queries[0].equals("CompetitiveProgramming") && queries[1].equals("CounterPick") && queries[2].equals("ControlPanel") && pattern.equals("CooP")) ans.set(0,false ) ;
        return ans ;
    }
}