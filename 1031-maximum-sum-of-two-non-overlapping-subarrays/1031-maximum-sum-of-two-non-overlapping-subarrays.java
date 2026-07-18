class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
       return Math.max(fun(nums, f, s), fun(nums, s, f)) ;
    }
    int fun (int[] nums, int f, int s) {
         int[] pre = new int[nums.length] ;
        int[] suff = new int[nums.length] ;
        Arrays.fill(pre, -1) ;

        int i = 0;
        int j = i+f-1 ;
        int sum = 0;
        for(int x =i; x<j; x++) sum+=nums[x] ;
        while(j < nums.length) {
            sum+=nums[j] ;
            if(j==0) pre[j] = sum ;
            else pre[j] = Math.max(sum, pre[j-1]) ;
            sum-=nums[i] ;
            i++;
            j++;
        }
        i = nums.length-1 ;
        j = i - s +1;
        sum = 0;
        for(int x = i; x>j; x--){
            sum+=nums[x] ;
        }
        while(j >= 0){
            sum+=nums[j] ;
            if(j == nums.length-1) suff[j] = sum ;
            else suff[j] = Math.max(sum, suff[j+1]) ;
            sum-=nums[i] ;
            j--;
            i--;
        }
        int max = Integer.MIN_VALUE ;
        for(i = 0+f-1; i<=nums.length-s-1; i++) {
            max = Math.max(pre[i]+suff[i+1], max) ;
        }
        return max ;
    }
}