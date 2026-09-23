class Solution {
    public int minOperations(int[] nums, int x) {
        if(x < nums[0] && x < nums[nums.length-1]) return -1 ;
        if(x == nums[0] || x== nums[nums.length-1]) return 1 ;
        if(x == 0) return  0; 

        int sum = 0;
        for(int i : nums) sum += i ;

        if(sum < x) return -1 ;

        int t = sum - x ;

        int max = Integer.MIN_VALUE ;

        int i = 0 ;
        int j = 0;

        int s = 0;
        while(j < nums.length) {
            s += nums[j] ;

            while(i < nums.length && s > t) {
                s -= nums[i];
                i++ ;
            }
            if(s == t) max = Math.max(j - i + 1, max) ;
            j++;
        }

        if(max == Integer.MIN_VALUE) return -1 ;
        return nums.length - max ;
    }
}