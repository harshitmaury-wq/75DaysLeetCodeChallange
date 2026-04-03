class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Long> hs = new HashSet<>();
      
        for(int i=0; i<nums.length; i++) {hs.add((long)nums[i]);}

        Arrays.sort(nums);
        int maxlen = 0;
        int len = 0;
        for(int i=0; i<nums.length; i++){
            len = 1;
            long t = (long)nums[i];
            while(hs.contains(t =(long)t*t)) len++;
            maxlen = Math.max(maxlen, len);

            
        }
        if(maxlen<2) return -1;
        return maxlen;
    }
}