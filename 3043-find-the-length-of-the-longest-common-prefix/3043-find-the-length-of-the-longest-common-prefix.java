class Solution {
    class Trie {
        Trie[] arr = new Trie[26] ;
        boolean iseow ;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie() ;

        for(int i = 0 ; i<arr1.length; i++) {
            StringBuilder sb = new StringBuilder() ;
            sb.append(arr1[i]) ;

            add(sb.toString(), root) ;
        }
        int max = Integer.MIN_VALUE ;

        for(int i = 0 ; i<arr2.length; i++) {
            StringBuilder sb = new StringBuilder() ;
            sb.append(arr2[i]) ;

            max = Math.max(max, find(sb.toString(), root)) ;
        }
        return max ;
    }
    void add(String s, Trie root) {
        Trie crawl = root ;

        for(int i = 0; i<s.length(); i++) {
            if(crawl.arr[s.charAt(i)-'0'] == null) {
                crawl.arr[s.charAt(i)-'0'] = new Trie() ;
            }
            crawl = crawl.arr[s.charAt(i)-'0'] ;
        }
    }

    int find(String s, Trie root) {
        Trie crawl = root;
        int len = 0; 
        for(int i = 0; i<s.length(); i++) {
            if(crawl.arr[s.charAt(i)-'0'] != null) {
                crawl = crawl.arr[s.charAt(i)-'0']  ;
                len++ ;
            }
            else break ;
        }

        return len ;
    }
}