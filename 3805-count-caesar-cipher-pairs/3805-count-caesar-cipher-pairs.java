class Solution {
    public long countPairs(String[] words) {

        HashMap<String, Integer> hm = new HashMap<>() ;
        long c = 0;
        for(int i = 0; i < words.length; i++) {
            
                for(int x = 0; x<=25; x++) {
                     StringBuilder sb = new StringBuilder() ;

            sb.append(words[i]) ;
                for(int j = 0; j<sb.length(); j++) {
                    sb.setCharAt(j, (char)(sb.charAt(j) + x) > 'z' ? (char)('a'+(sb.charAt(j) + x-'z')-1) : (char)(sb.charAt(j) + x)) ;
                }
                 if(hm.containsKey(sb.toString())) c+=hm.get(sb.toString() ) ;
            }
           
                if(hm.containsKey(words[i])) hm.put(words[i], hm.get(words[i]) + 1) ;
            else hm.put(words[i], 1) ;
        }
        return c;
    }
}