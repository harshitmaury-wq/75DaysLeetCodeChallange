class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans) ;

        long[] suff = new long[beans.length] ;
        long[] pre = new long[beans.length] ;

        pre[0] = beans[0] ;
        for(int i = 1; i<beans.length; i++) pre[i] = beans[i] + pre[i-1] ;

        suff[beans.length-1] = beans[beans.length-1] ;
        for(int i = beans.length-2; i>=0; i--) suff[i] = beans[i] + suff[i+1] ;

        int last = beans.length - 1 ;

        long min = Long.MAX_VALUE ;

        for(int i = 0; i< beans.length; i++) {
            long presum = i == 0 ? 0 : pre[i-1] ;
            long suffsum = i == last ? 0 : suff[i+1] ;

            long op = (suffsum - (1L*(last - i )*beans[i]) + presum) ;
            min = Math.min(min, op) ;
        }

        return min ;
        
    }
}