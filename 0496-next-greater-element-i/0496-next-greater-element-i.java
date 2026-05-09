class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int [] ans = new int[nums1.length];
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            hm.put(nums2[i], -1);
        }
        for(int i=0; i<nums2.length; i++){
            if(s.isEmpty()) s.push(i);
            else{
                while(!s.isEmpty() && nums2[i]>nums2[s.peek()]){
                    hm.put(nums2[s.pop()], nums2[i]);
                }
                s.push(i);
            }
        }
        for(int i=0; i<nums1.length; i++){
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}