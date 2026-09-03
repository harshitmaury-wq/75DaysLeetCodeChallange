class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;

        for(int i = 0; i<nums1.length; i++) {
            for(int j = 0; j<nums2.length; j++) {
                int sum = nums1[i] + nums2[j] ;

                if(hm.containsKey(sum)) hm.put(sum, hm.get(sum) + 1) ;
                else hm.put(sum, 1) ;
            }
        }


        int c = 0; 
        
        for(int i = 0; i<nums3.length; i++) {
            for(int j = 0; j<nums4.length; j++) {
                int sum = nums3[i] + nums4[j] ;

                if(hm.containsKey(-1 * sum)) c += hm.get(-1 * sum) ;
            }
        }

        return c ;
    }
}