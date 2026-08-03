class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int[] ans = new int[shifts.length] ;
        
        long[] pre = new long[tasks.length] ;
        pre[0] = tasks[0] ;

        for(int i = 1; i<tasks.length; i++) pre[i] = tasks[i] +pre[i-1];

        long rem = 0;

        int idx = 0;

        for(int i = 0; i<shifts.length; i++) {
            long time = shifts[i] + (idx==0?0:pre[idx -1 ]) + rem ;
            rem = 0;

            idx = bs(pre , time) ;
            
            ans[i] = tasks.length - 1 - idx ;
            if(idx >= 0 ) time -= pre[idx] ;
            

            idx++ ;
            
            if(idx >= tasks.length) {idx = 0; rem = 0; continue;} 

            

            rem = time ;
            
        }

        return ans ;
        
    }
    int bs (long[] arr, long t) {
        int s = 0;
        int e = arr.length -1;
        int ans = -1;
        while(s<=e) {
            int mid = s + (e - s ) / 2 ;

            if(arr[mid] <= t) {ans = mid ; s = mid + 1;}
            else e = mid - 1;
        }
        return ans ;
    }
}