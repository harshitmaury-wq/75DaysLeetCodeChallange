class Solution {
    public int maximumScore(int[] nums, int k) {
        int[] nsr = nmr(nums) ;
        int[] nsl = nml(nums) ;

        int ans = Integer.MIN_VALUE ;
        for(int i = 0; i<nums.length; i++) {
            int l = nsl[i] +1;
            int r = nsr[i] -1;

            if(l > k || r < k) continue ;
            ans = Math.max(ans, nums[i] * (r - l + 1)) ;

        }
        return ans ;
    }
    int[] nmr (int[] nums ){
        Stack<Integer> st = new Stack<>() ;
        int[] nmr = new int[nums.length] ;
        Arrays.fill(nmr, nums.length) ;

        int i = 0; 
        while(i < nums.length) {
            if(st.isEmpty()) st.push(i) ;

            else {
                while(!st.isEmpty() && nums[i] < nums[st.peek()]) nmr[st.pop()] = i ;
                st.push(i) ;
            }
            i++;
        }
        return nmr ;
    }

    int[] nml (int[] nums ){
        Stack<Integer> st = new Stack<>() ;
        int[] nml = new int[nums.length] ;
        Arrays.fill(nml, -1) ;

        int i = nums.length - 1; 
        while(i>=0) {
            if(st.isEmpty()) st.push(i) ;

            else {
                while(!st.isEmpty() && nums[i] < nums[st.peek()]) nml[st.pop()] = i ;
                st.push(i) ;
            }
            i--;
        }
        return nml ;
    }
}