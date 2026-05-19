class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0; i<chunks.length; i++) {
            sb.append(chunks[i]) ;
        }
        HashMap<String, Integer> hm = new HashMap<>();
       StringBuilder word = new StringBuilder() ;
        int n = sb.length() ;
         for(int i=0; i<n; i++){
         char ch = sb.charAt(i) ;
        
         if(ch >= 'a' && ch <= 'z') word.append(ch) ;
         else if (ch == '-'){
            if(word.length() > 0 && i+1 < n && sb.charAt(i+1) >= 'a' && sb.charAt(i+1) <= 'z') word.append(ch) ;
            else {
                if(hm.containsKey(word.toString())) hm.put(word.toString(), hm.get(word.toString())+1) ;
                else hm.put(word.toString(), 1) ;
                 word.setLength(0) ;
            }
         }
         else {
            
                if(hm.containsKey(word.toString())) hm.put(word.toString(), hm.get(word.toString())+1) ;
                else hm.put(word.toString(), 1) ;
                 word.setLength(0) ;

         }
       }

       if(word.length() != 0) {
                if(hm.containsKey(word.toString())) hm.put(word.toString(), hm.get(word.toString())+1) ;
                else hm.put(word.toString(), 1) ;
       }
       
       int[] ans = new int[queries.length] ;
       for(int i=0; i<ans.length; i++){
        if(hm.containsKey(queries[i]))
        ans[i] = hm.get(queries[i]) ;
        else ans[i] = 0;
       }
        return ans;
    }
}