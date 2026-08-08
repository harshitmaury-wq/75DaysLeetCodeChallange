class Solution {
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder() ;

        sb.append(s) ;
        int op = 0 ;
        int i = 0; 
        while(i<sb.length() && sb.charAt(i) == 'a') i++ ;

        if(i == sb.length() ) {sb.setCharAt(sb.length()-1, 'z') ;
        return sb.toString() ; }

       while(i < sb.length()) {
            if(sb.charAt(i) == 'a') break ;

            sb.setCharAt(i, (char)(sb.charAt(i) - 1)) ;

            i++ ;
       }

       return sb.toString() ;
    }
}