class Solution {
    public List<String> fullJustify(String[] words, int maxlength) {
        List<String> ans = new ArrayList<>() ;

        int n = words.length ;
        int i = 0; 
        int lettercount = words[i].length() ;

        while(i < n) {
            lettercount = words[i].length() ;
            int j = i+1 ;
            int spaces = 0;
            
            while( j<n && lettercount + words[j].length() + 1 + spaces <= maxlength) {
                
                lettercount += words[j].length() ;
                spaces++ ;
                

                j++ ;
            }


         
            
            int  remaining = maxlength - lettercount  ;
            int  space_add = spaces == 0 ? 0 : remaining / spaces ;
            int rem = spaces == 0 ? 0 : remaining % spaces ;
            
           if(j == n) {
            space_add = 1; 
            rem = 0 ;
           }
            
            String line = makeline(words, i, j-1, space_add, rem, maxlength) ;
            ans.add(line) ;

            i = j ; 
        }

        return ans ;
    }

    String makeline (String[] words, int i, int j, int space_add, int rem, int maxlength) {
        StringBuilder sb = new StringBuilder() ;

        for(int k = i; k<=j; k++) {
            sb.append(words[k]) ;
            
            if(k == j) continue ;

            int sp = space_add ;
            while(sp > 0) {
                sb.append(" ") ;
                sp-- ;
            }
            if(rem > 0) {
                sb.append(" ") ;
                rem -- ;
            }
        }

        while(sb.length() < maxlength) sb.append(" ") ;
       

        return sb.toString() ;
    }
}