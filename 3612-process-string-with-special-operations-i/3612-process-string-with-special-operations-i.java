class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder() ;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') sb.append(s.charAt(i)) ;
            else if(s.charAt(i)=='*'){
                if(sb.length()>0) sb.setLength(sb.length()-1) ;
            }
            else if(s.charAt(i)=='#') {
                String t = sb.toString() ;
                sb.append(t) ;
            }
            else if(s.charAt(i) == '%') sb.reverse() ;
        }

        return sb.toString() ;
    }
}