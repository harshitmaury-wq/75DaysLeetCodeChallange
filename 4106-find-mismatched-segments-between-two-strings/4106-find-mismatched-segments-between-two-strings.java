class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        
        List<List<String>> list = new ArrayList<>() ;
            StringBuilder sb1 = new StringBuilder() ;
            StringBuilder sb2 = new StringBuilder() ;

        for(int i = 0; i<s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                if(sb1.length() > 0 ) {
                    List<String> temp = new ArrayList<>() ;
                    temp.add(sb1.toString()) ;
                    temp.add(sb2.toString()) ;
                    list.add(temp) ;
                    sb1.setLength(0) ;
                    sb2.setLength(0) ;
                }
            }

            else {
            sb1.append(s1.charAt(i)) ;
            sb2.append(s2.charAt(i)) ;
            }


        }

        if(sb1.length() > 0 ) {
                    List<String> temp = new ArrayList<>() ;
                    temp.add(sb1.toString()) ;
                    temp.add(sb2.toString()) ;
                    list.add(temp) ;
                    sb1.setLength(0) ;
                    sb2.setLength(0) ;
                }

        return list ;
    }
}