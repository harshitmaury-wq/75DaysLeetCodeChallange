class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums) ;
        long[] pre = new long[nums.length] ;

        pre[0] = nums[0] ;
        List<Long> ans = new ArrayList<>() ;
        for(int i = 1; i<nums.length; i++) pre[i] = nums[i] + pre[i-1] ;
        
        for(int i = 0; i<queries.length; i++){
            int idx = bs(nums, queries[i]) ;
            if(idx == -1){
                long op = Math.abs(1L * nums.length * queries[i] - pre[nums.length - 1]);
                ans.add(op) ;
                continue; 
            }
            long one = 1L * queries[i] * (idx + 1);
            long two = 1L * (nums.length - 1 - idx) * queries[i];
            long op = 1L*(Math.abs(pre[idx]-one) + Math.abs(pre[nums.length-1] - pre[idx]- two)) ;
            ans.add(op) ;
        }
        return ans;
    }
    int bs(int[] arr , int t){
        int s = 0;
        int e = arr.length-1;
        int ans = -1 ;
        while(s<=e){
            int mid = s + (e - s) / 2 ;

            if(arr[mid] > t) e = mid - 1;
            else {ans = mid; s = mid + 1 ;}

        }
        return ans ;
    }
}