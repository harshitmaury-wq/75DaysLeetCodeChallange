class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
       
        int s = 1;
        int e = max;
        int ans = 0;
        while(s<=e){
            int mid = s+ (e-s)/2;
           long count = 0;
            for(int i = 0; i<piles.length; i++){
               if(piles[i]%mid==0) count+=piles[i]/mid;
               else count+=(piles[i]/mid + 1);
            }
            if(count > h) s = mid+1;
            else {
                ans = mid;
                e = mid-1;
            }
        }
        return ans;
    }
}