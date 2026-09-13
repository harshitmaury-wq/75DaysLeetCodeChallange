class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>() ;
        for(int i : nums1) {
            if(hm.containsKey(i)) hm.put(i, hm.get(i)+1) ;
            else hm.put(i, 1) ;
        }

        for(int i = -1000; i<= 1000; i++) {
            boolean b = true;
            for(int j = 0; j<nums2.length; j++) {
                
                int diff = nums2[j]-i ;
                if(!hm.containsKey(diff)) {
                    b = false ;
                    break;
                }

                hm.put(diff, hm.get(diff)-1) ;
                if(hm.get(diff) == 0) hm.remove(diff) ;

            }

            if(b) return i ;

            hm.clear() ;
            for(int k : nums1) {
            if(hm.containsKey(k)) hm.put(k, hm.get(k)+1) ;
            else hm.put(k, 1) ;
        }

            
        }

        return -1;
    }
}