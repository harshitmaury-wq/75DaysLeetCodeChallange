class Solution {
    class Trie{
        Trie[] arr = new Trie[26] ;
        int visits = 0;
    }
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie() ;
        for(int i = 0; i<words.length; i++){
            insert(root, words[i]) ;
        }
        int[] ans = new int[words.length] ;
        for(int i = 0; i<words.length; i++){
            ans[i] = vis(root, words[i]) ;
        }
        return ans ;
        
    }
    void insert(Trie root, String s){
        Trie crawl = root;
        for(int i = 0; i<s.length(); i++){
            if(crawl.arr[s.charAt(i)-'a'] == null ) {
                crawl.arr[s.charAt(i)-'a'] = new Trie() ;
            }
           
            crawl = crawl.arr[s.charAt(i)-'a'] ;
             crawl.visits++ ;
        }
    }
    int vis (Trie root, String s){
        Trie crawl = root ;
        int c = 0;
        for(int i = 0; i< s.length(); i++){
           
            crawl = crawl.arr[s.charAt(i)-'a'] ;
             c+=crawl.visits;
        }
        return c ;
    }
}