class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>() ;
        List<Integer> list = new ArrayList<>() ;

        int i = 0; 
        int j = 0; 
        
        while(j < nums.length) {
            while(!dq.isEmpty() && nums[j] > nums[dq.peekLast()] ) dq.removeLast();

            dq.addLast(j) ;
            if(j - i + 1 == k) {
                list.add(nums[dq.peekFirst()]) ;

                if(dq.peekFirst() == i) dq.removeFirst() ;
                i++;
            }
            j++;
        }

        int[] arr = new int[list.size()] ;
        int x = 0; 
        for(Integer y : list) {
            arr[x++] = y ;
        }

        return arr;
    }
}