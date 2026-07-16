class Solution {
    class Trie{
        Trie[] arr = new Trie[26] ;
        boolean iseow = false ;
    }
    public String replaceWords(List<String> d, String s) {
        StringBuilder sb = new StringBuilder() ;
        String[] sen = s.split(" ") ;
        Trie root = new Trie() ;
        for(String st : d) insert(root, st) ;

        for(int i = 0; i<sen.length; i++){
            sb.append(search(root, sen[i])) ;
            sb.append(" ") ;
        }
        sb.setLength(sb.length()-1) ;
        return sb.toString() ;
    }
    void insert(Trie root, String s){
        Trie crawl = root ;
        for(int i= 0; i<s.length(); i++){
            if(crawl.arr[s.charAt(i) - 'a'] == null){
                crawl.arr[s.charAt(i) - 'a'] = new Trie() ;
            }
            crawl = crawl.arr[s.charAt(i) - 'a'] ;
        }
        crawl.iseow = true ;
    }
    String search (Trie root, String t) {
        Trie crawl = root ;
        StringBuilder sb = new StringBuilder() ;
        for(int i = 0; i<t.length(); i++){
            if(crawl.arr[t.charAt(i) - 'a'] == null) return t ;
            crawl = crawl.arr[t.charAt(i) -'a'] ;
            sb.append(t.charAt(i)) ;
            if(crawl.iseow == true) return sb.toString() ;
        }
       
        return t ;
    }
}