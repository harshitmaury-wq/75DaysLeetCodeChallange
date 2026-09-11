class Solution {
    public List<Integer> countSmaller(int[] num) {
        int[] nums = num.clone() ;
        Arrays.sort(nums) ;
        ArrayList<Integer> list = new ArrayList<>() ;

        int last = -10001 ;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != last) {
                list.add(nums[i]) ;
                last = nums[i] ;
            }
        }

        int[] arr = new int[nums.length] ;
        for(int i = 0; i<nums.length; i++) {
            arr[i] = Collections.binarySearch(list, num[i]) ;
        }
        
        int[] idx = new int[list.size()] ;

        int[] st = new int[4*idx.length] ;

        List<Integer> ans = new ArrayList<>() ;
        for(int i = arr.length -1 ; i>=0; i--) {
            update(0, 0, idx.length-1, arr[i], st, idx) ;
            ans.add(findsum(0, 0, idx.length-1, 0, arr[i]-1, st)) ;
        }

        Collections.reverse(ans) ;

        return ans ; 
        
    }
    void update (int curr, int s, int e, int t, int[] st, int[] idx) {
        if(s == e) {
            idx[t]++;
            st[curr] ++ ;
            return ;
        }
        
        int mid = s + (e - s) / 2 ;
        if(t <= mid) update(2*curr+1, s, mid, t, st, idx) ;
        else update(2*curr+2, mid + 1, e,t, st, idx) ;

        st[curr] = st[2*curr+1] + st[2*curr + 2] ;
    }

    int findsum(int curr, int s, int e, int l, int r, int[] st) {
        if(r < s || l > e) return 0;
        if(l <= s && e <= r) return st[curr];
        

        int mid = s + (e - s) / 2 ;

        return findsum(2*curr+1,s, mid, l, r, st) + findsum(2*curr+2, mid+1,e, l, r, st) ;
    }
}