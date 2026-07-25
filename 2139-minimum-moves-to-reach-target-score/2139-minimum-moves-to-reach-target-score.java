class Solution {
    public int minMoves(int target, int md) {
        int op = 0 ;
        while(target != 1) {
            if(target %2 == 0 ) {
                if(md == 0) {
                    op+=(target - 1) ;
                    target = 1 ;
                }
                else {
                op++;
                md--;
                target/=2 ;
                }
            }

            else {
                op++;
                target-- ;
            } 
            
                
            
        }
        return op ;
    }
}