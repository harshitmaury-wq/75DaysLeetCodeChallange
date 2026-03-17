class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
       PriorityQueue<Integer> pq =
    new PriorityQueue<>((b, a) -> hm.get(b) - hm.get(a));

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])) hm.put(nums[i],hm.get(nums[i])+1);
            else hm.put(nums[i],1);
        }
        int[] ans=new int[k];
        int j=0;
        for(Integer i: hm.keySet()){
            if(j<k){
            pq.add(i);}
            else{
                if(hm.get(i)>hm.get(pq.peek())){
                    pq.remove();
                    pq.add(i);
                }
            }
            j++;
        }
       for(int i=0;i<ans.length; i++){
        ans[i]=pq.remove();
       }
        return ans;

    }
}