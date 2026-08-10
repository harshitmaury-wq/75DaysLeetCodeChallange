class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position) ;
       
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE ;

        for(int i = 0; i<position.length; i++){
            max = Math.max(max, position[i]) ;
            min = Math.min(min, position[i]) ;
        }

        int s = 0; 
        int e = max - min  ;
        int ans = -1 ;

        while(s<=e ) {
            int mid = s+(e- s) / 2;

            int balls = 0;
            int last = position[0] ;

            for(int i = 0; i<position.length; i++) {
                if(position[i] >= last){
                    balls++;
                    last = position[i] + mid ;
                }
            }
            if(balls >= m) {ans = mid; s = mid + 1 ;}
            else e = mid - 1;
        }
        return ans ;
    }
}