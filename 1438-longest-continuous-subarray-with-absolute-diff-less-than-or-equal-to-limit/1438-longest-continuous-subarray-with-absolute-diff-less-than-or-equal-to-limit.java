class Solution {
    public int longestSubarray(int[] nums, int limit) {
        HashSet<Integer> hs = new HashSet<>() ;
        PriorityQueue<Integer> minpq = new PriorityQueue<>((a,b) -> {return nums[a] - nums[b];}) ;
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a,b) -> {return nums[b] - nums[a];}) ;
        Deque<Integer> dq = new LinkedList<>() ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0; i< nums.length; i++){
            minpq.add(i) ;
            maxpq.add(i) ;
            dq.addLast(i) ;
          
            while(!dq.isEmpty() && nums[maxpq.peek()] - nums[minpq.peek()] > limit) {
                hs.add(dq.removeFirst());
                while(hs.contains(maxpq.peek())) maxpq.remove() ;
                while(hs.contains(minpq.peek())) minpq.remove() ;
                
            }
            max = Math.max(max, dq.size()) ;
        }
        return max ;
    }
}