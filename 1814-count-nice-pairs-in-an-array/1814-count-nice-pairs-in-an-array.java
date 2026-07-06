class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>() ;
        int c = 0;
        for(int i = 0; i<nums.length; i++){
            if(hs.containsKey(nums[i]-ri(nums[i]))) {
                c += hs.get(nums[i]-ri(nums[i])) ;
                c = c%1000000007 ;
                hs.put(nums[i]-ri(nums[i]), hs.get(nums[i]-ri(nums[i])) + 1) ;
            }
            else hs.put(nums[i]-ri(nums[i]), 1) ;
        }
        return c%1000000007 ;
    }
    int ri (int n) {
        StringBuilder sb = new StringBuilder() ;
        sb.append(n) ;
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '0') sb.setLength(sb.length()-1) ;
        sb.reverse() ;
        if(sb.length()==0) return 0 ;
        return Integer.parseInt(sb.toString()) ;
    }
}