class Solution {
    public String largestMerge(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder() ;
        while(i<word1.length() && j<word2.length()) {
            int cmp = word1.substring(i, word1.length()).compareTo(word2.substring(j, word2.length())) ;
            if(cmp > 0) {
                sb.append(word1.charAt(i)) ;
                i++ ;
            }
            else {
                sb.append(word2.charAt(j));
                j++ ;
            }
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i)) ;
            i++; 
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j)) ;
            j++; 
        }
        return sb.toString() ;
    }
}