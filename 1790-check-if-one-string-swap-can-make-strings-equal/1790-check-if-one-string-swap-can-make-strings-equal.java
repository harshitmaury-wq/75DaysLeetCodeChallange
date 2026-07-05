class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>() ;

        for(int i = 0; i<s1.length(); i++){
            if(hm.containsKey(s1.charAt(i))) hm.put(s1.charAt(i), hm.get(s1.charAt(i)) + 1) ;
            else hm.put(s1.charAt(i), 1) ;
        }
        for(int i = 0; i<s2.length(); i++){
            if(!hm.containsKey(s2.charAt(i))) return false ;
            else hm.put(s2.charAt(i), hm.get(s2.charAt(i)) -1 ) ;

            if(hm.get(s2.charAt(i)) == 0) hm.remove(s2.charAt(i)) ;
        }

        if(!hm.isEmpty()) return false ;
        int c = 0;
        for(int i = 0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) c++;
        }
        if(c ==2 || c == 0) return true;
        return false ;
    }
}