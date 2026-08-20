class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] premax = new int[nums.length ] ;
        premax[nums.length-1] = nums[nums.length-1] ;

        for(int i = premax.length-2; i>=00; i--) premax[i] = Math.max(premax[i+1], nums[i]) ;

        int max = 0;
        for(int i = 0; i<nums.length; i++) {
            int t = nums[i] ;
            int idx = bs(i+1, nums.length-1, premax, t) ;
            if(t == -1) continue ;

            max = Math.max(max, idx - i) ;
        }
        
        return max ;
        
    }

    int bs (int s, int e, int[] arr, int t) {
        int ans = -1 ;
        while(s <= e) {
            int mid = s + (e - s) / 2 ;

            if(arr[mid] >= t) {ans = mid ; s = mid + 1 ;}
            else e = mid - 1;
        }

        return ans;
    }
}