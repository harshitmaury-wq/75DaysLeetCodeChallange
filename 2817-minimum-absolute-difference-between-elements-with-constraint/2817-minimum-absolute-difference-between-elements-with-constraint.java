class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int min = Integer.MAX_VALUE ;
        TreeMap<Integer, Integer> tm  = new TreeMap<>() ;

        for(int i = x; i<nums.size(); i++) {
            if(tm.containsKey(nums.get(i))) tm.put(nums.get(i), tm.get(nums.get(i)) + 1 ) ;
            else tm.put(nums.get(i) , 1) ;
        }
        int j = x;
        int i = 0 ;

        while(j < nums.size()) {
            int justgreater, justsmaller ;

            Integer a = tm.ceilingKey(nums.get(i)) ;
            Integer b = tm.floorKey(nums.get(i)) ;

            if( a != null) justgreater = a - nums.get(i);
            else justgreater = Integer.MAX_VALUE ;
            if(b != null ) justsmaller = nums.get(i) - b ;
            else justsmaller = Integer.MAX_VALUE ;

            min = Math.min(min, Math.min(justgreater, justsmaller)) ;

            tm.put(nums.get(j), tm.get(nums.get(j)) - 1) ;
            if(tm.get(nums.get(j)) == 0) tm.remove(nums.get(j)) ;

            i++; j++ ;
        }
        return min ;
    }
}