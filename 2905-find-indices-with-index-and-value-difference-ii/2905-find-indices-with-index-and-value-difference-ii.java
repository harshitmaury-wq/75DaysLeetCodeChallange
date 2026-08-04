class Solution {
    public int[] findIndices(int[] nums, int id, int vd) {
        TreeMap<Integer, Integer> tm = new TreeMap<>() ;

        int i = 0;
        int j = id ;

        for(int x = j; x<nums.length; x++) {
          tm.put(nums[x], x) ;
            
        } 

        while(j < nums.length) {
            int t1 = nums[i] + vd ;
            int t2 = nums[i] - vd ;

            Integer justGreaterOrEqual = tm.ceilingKey(t1) ;
            Integer justsmaller = tm.floorKey(t2) ;
            if( justGreaterOrEqual != null ) return new int[]{i, tm.get(justGreaterOrEqual) } ;

             if( justsmaller != null ) return new int[]{i, tm.get(justsmaller) } ;


           

            
            tm.remove(nums[j]) ;

            i++; j++ ;
        }
        return new int[]{-1, -1 } ;
    }
  
}