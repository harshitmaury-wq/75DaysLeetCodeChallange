class Solution {
    public int destroyTargets(int[] nums, int space) {
       

        HashMap<Integer, Integer> hm = new HashMap<>() ;

        int max = Integer.MIN_VALUE ;
        for(int i = 0; i<nums.length; i++) {
            if(hm.containsKey(nums[i]%space)) hm.put(nums[i]%space, hm.get(nums[i] %space) +1) ;
            else hm.put(nums[i]%space , 1 ) ;
            max = Math.max(max, hm.get(nums[i]%space)) ;

        }

        int min = Integer.MAX_VALUE ;
        for(int i = 0; i<nums.length; i++) {
            if(hm.get(nums[i]%space) == max) min = Math.min(min, nums[i]) ;
        }
        return min ;
    }   
}