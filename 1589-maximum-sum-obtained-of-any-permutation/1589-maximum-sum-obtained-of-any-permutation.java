class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] r) {
        int[] diff = new int[nums.length] ;

        for(int i= 0; i<r.length; i++){
            diff[r[i][0]] += 1;
            int n = r[i][1] + 1;
            if(n<=diff.length-1 ) diff[n] += -1;
        }
        for(int i = 1; i<diff.length; i++) diff[i] = diff[i-1] + diff[i] ;
         int i = diff.length-1;
        Arrays.sort(diff) ;
        Arrays.sort(nums) ;

        long sum = 0;
        while(i>=0) {
            sum+=((1L*(nums[i]%1000000007)*(diff[i]%1000000007))%1000000007);
            i--;
        }
        return (int)(sum%1000000007) ;
    }
}