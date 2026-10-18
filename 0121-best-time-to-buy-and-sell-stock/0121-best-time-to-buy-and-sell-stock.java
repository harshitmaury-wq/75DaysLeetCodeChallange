class Solution {
    public int maxProfit(int[] prices) {
        int[] pre = new int[prices.length] ;
        int[] suf = new int[prices.length] ;

        pre[0] = prices[0] ;
        suf[prices.length-1] = prices[prices.length-1] ;

        for(int i =1 ; i<prices.length; i++) {
            pre[i] = Math.min(prices[i], pre[i-1]) ;
        }  

        for(int i = prices.length-2; i>=0; i--) {
            suf[i] = Math.max(suf[i+1], prices[i]) ;
        } 

        int max = 0; 

        for(int i = 0; i<prices.length; i++) {
            max = Math.max(max, suf[i]-pre[i]) ;
        }


        return max ;
    }
}