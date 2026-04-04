class Solution {
    public int minOperations(int[] nums, int k) {
      PriorityQueue<Long> pq = new PriorityQueue<>();

      for(int i=0; i<nums.length; i++){
        pq.add((long)nums[i]) ;
      }  
      int op = 0;

      while(!pq.isEmpty() && pq.peek() < k){
        long a = pq.remove();
        long b = pq.remove();
        op++;
        long c = Math.min(a,b)*2 + Math.max(a,b);
        pq.add(c);
      }
      return op;
    }
}