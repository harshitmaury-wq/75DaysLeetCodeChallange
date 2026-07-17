class Solution {
    class Trie{
        Trie left = null ;
        Trie right = null ;
    }
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie() ;
        for(int i = 0; i<nums.length; i++) {
             insert(root, nums[i]) ;
           
        }
        StringBuilder sb = new StringBuilder() ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0; i<nums.length; i++){
    
                
                max = Math.max(max, search(root, nums[i])) ;
            
        }
        return max ;
    }
    void insert(Trie root, int num) {

        Trie crawl = root ;
        for(int i = 31; i>=0; i--) {
        int b = ( num >> i ) & 1 ;
        if(b==0) {
            if(crawl.left == null) crawl.left = new Trie() ;
            crawl = crawl.left ;
        }
        else{
            if(crawl.right == null) crawl.right = new Trie();
            crawl = crawl.right ;
        }
        }
    }
    int search(Trie root, int n){
        StringBuilder sb = new StringBuilder() ;
        Trie crawl = root;
        for(int i = 31; i>=0; i--) {
            int b = ( n>>i ) & 1 ;
            if(b==1){
                if(crawl.left != null) {
                    sb.append(1);
                    crawl = crawl.left ;
                }
                else {
                    sb.append(0) ;
                    crawl = crawl.right ;
                }
            }
            else {
                if(crawl.right != null) {
                    sb.append(1);
                    crawl = crawl.right ;
                }
                else {
                    sb.append(0) ;
                    crawl = crawl.left ;
                }
            }
        }
        return Integer.parseInt(sb.toString(), 2) ;
    }
}