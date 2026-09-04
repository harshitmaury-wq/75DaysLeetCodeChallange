class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums) ;

        int[] pre = new int[nums.length] ;
        pre[0] = nums[0] ;
        for(int i = 1; i<nums.length; i++)
        pre[i] = nums[i] + pre[i-1] ;

        int max = 1 ;
        for(int i = 1; i<nums.length; i++) {
            max = Math.max(max, bs(nums, i, pre, k)) ;
        }

        return max ;
    }

    int bs (int[] arr, int t, int[] pre, int k) {
        int s= 0; 
        int e = t -1;

        int ans = -1 ;

        while(s <= e) {
            int mid = s + (e - s) / 2 ;

            int window = t-1 - mid + 1 ;
            int winsum = window * arr[t] ;
            int actualsum = pre[t-1] - (mid - 1 < 0 ? 0 : pre[mid - 1]) ;

            if(winsum - actualsum > k) s = mid + 1;
            else {
                ans = window + 1 ;
                e = mid - 1 ;
            }
        }

        return ans ;
    }
}