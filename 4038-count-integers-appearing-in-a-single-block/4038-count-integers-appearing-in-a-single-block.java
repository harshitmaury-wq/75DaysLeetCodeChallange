class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        for(int i : nums) {
            if(hm.containsKey(i)) hm.put(i, hm.get(i) +1) ;
            else hm.put(i, 1) ;
        }

        int ans = 0 ;
        for(int i = 0; i<nums.length; i++) {
            int c = 1 ;
            while(i < nums.length - 1 && nums[i] == nums[i+1]) {
                c++; 
                i++ ;
            }
            if(hm.get(nums[i]) == c) ans++;
        }

        return ans ;
    }
}