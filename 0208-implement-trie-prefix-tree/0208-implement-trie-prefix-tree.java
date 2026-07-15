class Trie {
    Trie[] arr ;
    boolean iseow ;

    public Trie() {
        this.arr = new Trie[26] ;
        this.iseow = false ;
    }
    
    public void insert(String word) {
        Trie crawl = this ;
        for(int i = 0; i<word.length(); i++){
            if(crawl.arr[word.charAt(i)-'a'] == null ){
                crawl.arr[word.charAt(i)-'a'] = new Trie() ;
            }
            crawl = crawl.arr[word.charAt(i)-'a'] ;
        }
        crawl.iseow = true ;
    }
    
    public boolean search(String word) {
        Trie crawl = this ;
        for(int i = 0; i<word.length(); i++){
            if(crawl.arr[word.charAt(i)-'a'] == null ){
                return false ;
            }
            crawl = crawl.arr[word.charAt(i)-'a'] ;
        }
        if(crawl.iseow) return true;
        return false ;
    }
    
    public boolean startsWith(String word) {
        Trie crawl = this ;
        for(int i = 0; i<word.length(); i++){
            if(crawl.arr[word.charAt(i)-'a'] == null ){
                return false ;
            }
            crawl = crawl.arr[word.charAt(i)-'a'] ;
        }
         return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */