class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // atleast (k) - atleast (k + 1) 

        return fun(nums, k) - fun(nums, k+1) ;
    }
    int fun (int[] nums, int k ) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int i = 0; 
        int j = 0; 
        int ans = 0; 

        while(j < nums.length) {
            if(hm.containsKey(nums[j])) hm.put(nums[j] , hm.get(nums[j]) + 1) ;
            else hm.put(nums[j], 1) ;

            while(hm.size() >= k) {
                ans = ans + nums.length - j ;
                hm.put(nums[i], hm.get(nums[i]) - 1) ;
                if(hm.get(nums[i]) == 0) hm.remove(nums[i]) ;
                i++ ;
            }

            j++ ;
        }

        return ans ;
    }
}