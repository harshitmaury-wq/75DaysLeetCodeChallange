class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int i = 0; 
        int j = 0;

        HashMap<Character, Integer> hm = new HashMap<>() ;
        int max =0;

        while(j<s.length()) {
            
            char c = s.charAt(j) ;

            while(hm.containsKey(c)) {
               hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1) ;
               if(hm.get(s.charAt(i)) == 0) hm.remove(s.charAt(i)) ;
                i++;
            }

           if(hm.containsKey(c)) hm.put(c, hm.get(c) + 1) ;
           else hm.put(c, 1) ;
            max = Math.max(max, j-i+1) ;

            j++ ;

        }

        return max ;
    }
}