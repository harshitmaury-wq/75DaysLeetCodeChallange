class Solution {
    public int getLength(int[] nums) {
       int n = nums.length ;
        TreeMap<Integer, Integer> tm = new TreeMap<>() ;
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int max = Integer.MIN_VALUE ;
        
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(hm.containsKey(nums[j])) {
                    int val = hm.get(nums[j]) ;
                    tm.put(val, tm.get(val) - 1) ;
                    if(tm.get(val)==0) tm.remove(val) ;
                hm.put(nums[j], hm.get(nums[j])+1) ;
                    
                    
                }
                else hm.put(nums[j], 1) ;

                int value = hm.get(nums[j]) ;
                
                if(tm.containsKey(value)) tm.put(value, tm.get(value) + 1) ;
                else tm.put(value , 1) ;          

                int small = tm.firstKey() ;
                int lar = tm.lastKey() ;
                if((tm.size() == 1 && tm.get(small) == 1) || (tm.size() == 2 && lar == 2*small)) max = Math.max(max, j-i+1) ;  
                
            }
                hm.clear();
                tm.clear() ;
        }
        return max ;
    }
}