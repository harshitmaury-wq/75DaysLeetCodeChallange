class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        
        int oprs = 0;

        for(int i = 0; i<nums.length; i++) {
            if(i == nums[i] - 1) continue ;

            int oi = nums[i] - 1 ;
            int a,b;

            if(oi < i) { a = oi; b = i ;}
            else b = oi; a = i ;

            for(int j = a ; j <= b; j++) {
                if(locked[j] == 1) {
                    locked[j] = 0;
                    oprs++;
                }
            }
        }

        if(oprs > k) return -1 ;

        for(int i = 0; i< nums.length; i++) {
            for(int j = 0; j<nums.length-1-i; j++) {
                if(nums[j] > nums[j+1]) {swap(j,j+1,nums) ; oprs++;}
            }
        }
        return oprs ;
    }

    void swap (int a, int b, int[] arr) {
        int temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp;
    }

}