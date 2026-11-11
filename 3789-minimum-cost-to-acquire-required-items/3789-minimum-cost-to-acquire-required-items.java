class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        long constant = 1L*need1 * cost1 + 1L*need2 * cost2 ;
        long var = costBoth - cost1 - cost2 ;
        long x ;

        if(var < 0) {

            x = constant / Math.abs(var) ;
            if(x > Math.min(need1,need2)) x = Math.min(need1, need2) ;

        }

        else x = 0;



        long a = 1L*x * costBoth ;
        long b = 1L*(need1 - x)* cost1 ;
        if(b < 0) b = 0;
        long c = 1L*(need2 - x)* cost2 ;
        if(c<0) c = 0 ;

        long ans = a + b + c ;

        long ct = 1L * Math.max(need1, need2) * costBoth ;
        long d = 1L*cost1 * need1 + 1L*cost2 * need2 ;
        return Math.min(Math.min(ans,ct),d) ;
    }
}