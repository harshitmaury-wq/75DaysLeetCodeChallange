class Solution {
    public boolean predictTheWinner(int[] piles) {
        
  

        int sum = 0;
        for(int i : piles) sum += i ;

        int p1 = fun(piles, 0, piles.length-1 ) ;
        return p1 >= (sum-p1) ;
        
    }
    int fun (int[] piles, int i, int j) {
        if(j == i+1) return Math.max(piles[i], piles[j]) ;
        if(i == j) return piles[j] ;


        int take_i = piles[i] + Math.min(fun(piles, i+2, j), fun(piles, i+1, j-1)) ;
        int take_j = piles[j] + Math.min(fun(piles, i, j-2), fun(piles, i+1, j-1)) ;

        return Math.max(take_i, take_j) ;
    }
}
