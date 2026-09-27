class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<ArrayList<Integer>, Integer> hm = new HashMap<>() ;

        int ans = 0;
        for(int i = 0; i<nums.length-1; i++) {
            ArrayList<Integer> list = new ArrayList<>() ;
            if(nums[i] == nums[i+1]) {ans ++; continue; }
            list.add(nums[i]);
            list.add(nums[i+1]) ;
            Collections.sort(list) ;
            if(hm.containsKey(list)) hm.put(list, hm.get(list)+1) ;
            else hm.put(list, 1) ;
        }

        int max = Integer.MIN_VALUE ;

        for(ArrayList<Integer> a : hm.keySet()) {
            max = Math.max(max, hm.get(a)) ;
        }

        return max == Integer.MIN_VALUE ? ans : ans + max ;
    }

}