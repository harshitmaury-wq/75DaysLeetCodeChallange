class Solution {

    boolean[] s = new boolean[100001] ;
    void solve () {
    Arrays.fill(s, true) ;
    s[0] = false ;
    s[1] = false ;
    
    for(int i = 2; i*i<s.length; i++) {
        if(s[i]) {
        for (int j = i * i; j <= 100000; j += i) {
            s[j] = false;
        }
    }
    }
    }
    public int longestSubarray(int[] nums, int k) {
       solve() ;
       HashMap<Integer, Integer> hm = new HashMap<>() ;

       int x = 0; 
       int j = 0;
        
        int max = 0 ;
       while(j<nums.length) {

            int n = nums[j] ;

            if(s[n] ) {
                if(hm.containsKey(n)) hm.put(n, hm.get(n) + 1) ;
                else hm.put(n, 1) ;
            }
            else {
            for(int i = 2; i*i <=n ; i++) {
            if(n%i == 0) {
                if(s[i]) {
                    if(hm.containsKey(i)) hm.put(i, hm.get(i) + 1) ;
                    else hm.put(i, 1) ;
                }
                int q = n/i ;
                if(q != i && s[q]) {
                    if(hm.containsKey(q)) hm.put(q, hm.get(q) + 1) ;
                    else hm.put(q, 1) ;
                }
            }
        }
            
    }   
            while(hm.size() > k) {
                 int m = nums[x] ;
                 if(s[m] ) {
                hm.put(m, hm.get(m) - 1) ;
              if(hm.get(m) == 0) hm.remove(m) ;
            }

            else {
            for(int i = 2; i*i <=m ; i++) {
            if(m%i == 0) {
                if(s[i]) {
                    hm.put(i, hm.get(i) - 1) ;
                    if(hm.get(i) == 0) hm.remove(i) ;
                    
                }
                int q = m/i ;
                if(q != i && s[q]) {
                     hm.put(q, hm.get(q) - 1) ;
                    if(hm.get(q) == 0) hm.remove(q) ;
                }
            }
        }
    }
            x++;
        }

        max = Math.max(max, j-x+1) ;
        j++ ;
                    
       }
        return max;
    }
    

}