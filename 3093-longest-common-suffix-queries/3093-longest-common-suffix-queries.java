class Solution {
    class Node{
        String s ;
        int idx;
        Node(String s, int idx){
            this.s = s;
            this.idx = idx ;
        }
    }
    class Trie{
        Trie[] arr;
        boolean iseow;
        int idx;
        Trie(int idx){
            this.arr = new Trie[26] ;
            this.iseow = false ;
            this.idx = idx;
        }
    }
    public int[] stringIndices(String[] wc, String[] wq) {
        ArrayList<Node> list = new ArrayList<>() ;
        for(int i = 0; i<wc.length; i++){
            list.add(new Node(wc[i], i)) ;
        }
        Collections.sort(list, (a,b)-> {
            if(a.s.length() < b.s.length()) return -1;
            else if(a.s.length() > b.s.length()) return 1 ;
            else {
                if(a.idx < b.idx) return -1;
                else if (a.idx > b.idx) return 1 ;
                else return 0 ;
            }
        });
        int[] ans = new int[wq.length] ;
        Trie root = new Trie(list.get(0).idx) ;
        for(int i = 0; i<list.size(); i++){
            insert(root, list.get(i).s, list.get(i).idx) ;
        }
        
        for(int i = 0; i<ans.length; i++){
            int t= search(root, wq[i]) ;
            ans[i] = t;
        }
        return ans ;

    }
    void insert(Trie root, String s, int i) {
        Trie crawl = root ;
        for(int j = s.length()-1; j>=0; j--){
            if(crawl.arr[s.charAt(j)-'a'] == null ){
                crawl.arr[s.charAt(j)-'a'] = new Trie(i) ;
            }
            crawl = crawl.arr[s.charAt(j)-'a'] ;
        }
        crawl.iseow = true ;
    }
    int search (Trie root , String s){
        Trie crawl = root ;
        
        int ind = root.idx;
        for(int i = s.length()-1; i>=0; i--){
            if(crawl.arr[s.charAt(i)-'a'] == null ) break ;
            
            
            crawl = crawl.arr[s.charAt(i)-'a'] ;
            ind = crawl.idx ;
        }
        return ind ;
    }
}