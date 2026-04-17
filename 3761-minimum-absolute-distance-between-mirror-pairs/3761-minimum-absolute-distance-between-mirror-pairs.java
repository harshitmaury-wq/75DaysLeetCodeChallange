class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])) min = Math.min(min, Math.abs(hm.get(nums[i])-i));
            hm.put(fun(nums[i]), i) ;
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
    static int fun (int s) {
        StringBuilder sb = new StringBuilder() ;

        sb.append(s);
        int j = sb.length()-1;
        while(sb.charAt(j)=='0') {sb.setLength(sb.length()-1); j--; }
        sb.reverse();
        return Integer.parseInt(sb.toString());

    }
}
