class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k != 0) return false ;
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int i=0; i<nums.length; i++){
            if(tm.containsKey(nums[i])) tm.put(nums[i], tm.get(nums[i])+1);
            else tm.put(nums[i], 1);
        }
        while(!tm.isEmpty()){
            int t = tm.firstKey();
            
            for(int i=1; i<=k; i++){
                
                if(!tm.containsKey(t)) return false;
                else {
                    tm.put(t, tm.get(t)-1);
                    if(tm.get(t)==0) tm.remove(t);
                    t++;
                }
            }
        }
        return true;
    }
}