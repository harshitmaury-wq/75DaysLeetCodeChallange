class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()] ;

        int last = -1;

        

        for(int i = 0; i<seq.length(); i++) {
            if(last == -1){
                ans[i] = 0 ;
                last = 0;
                continue ;
            }

            if(seq.charAt(i) == ')') {
                ans[i] = last ;
                last = (last == 1 ? 0 : 1) ;
            }

            else {
                ans[i] = (last == 1 ? 0 : 1) ;
                last = ans[i] ;
            }
        }
        return ans ;
    }
}