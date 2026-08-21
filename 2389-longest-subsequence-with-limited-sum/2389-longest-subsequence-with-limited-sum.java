class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums) ;
        int[] pre = new int[nums.length] ;

        int[] ans = new int[queries.length] ;

        pre[0] = nums[0] ;

        for(int i = 1; i<nums.length; i++) pre[i] = nums[i] + pre[i-1] ;

        for(int i = 0; i<queries.length; i++) {
            int t = queries[i] ;

            int idx = bs(pre, t ) ;

            if(idx == -1) {ans[i] = 0 ; continue ;}

            else ans[i] = idx + 1 ;
        }

        return ans;
    }

    int bs (int[] arr, int t) {
        int s = 0; 
        int e= arr.length-1 ;
        int ans = -1;
        while(s<=e) {
            int mid = s + (e - s) / 2 ;


            if(arr[mid] <= t) {ans = mid ; s = mid + 1 ;}
            else e = mid - 1 ;
        }

        return ans ;
    }
}