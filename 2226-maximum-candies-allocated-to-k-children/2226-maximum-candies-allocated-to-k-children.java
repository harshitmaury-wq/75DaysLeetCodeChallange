class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE ;
        for(int i : candies) max = Math.max(max, i) ;

        int s = 1;
        int e = max ;

        int ans = 0 ;
        while(s <= e) {
            int mid = s + (e - s) / 2 ;
            

            long c = 0; 
            for(int i = 0; i< candies.length; i++) {
                c += (candies[i]/mid) ;
            }

            if(c >= k) {ans = mid ; s = mid + 1 ; }
            else e = mid - 1;
        }
        return ans ;
    }
}