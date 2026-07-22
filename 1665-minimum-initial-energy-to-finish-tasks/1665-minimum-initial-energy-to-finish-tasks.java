class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) ->
    (b[1] - b[0]) - (a[1] - a[0]));
        int s = 1;

        int e = 0;
        int s1 = 0;
        int s2 = 0;
        for(int i = 0; i<tasks.length; i++) {s1+=tasks[i][0] ; s2+=tasks[i][1] ;} 
        e = Math.max(s1, s2) ;
        int ans = -1 ;
        while(s <= e) {
            int mid = s+(e - s) / 2;
            
            if(fun(tasks, mid)) { ans = mid; e = mid - 1 ;}
            else s = mid + 1 ;
        }
        return ans ;
    }
    boolean fun (int[][] tasks, int en) {
        for(int i = 0; i<tasks.length; i++) {
            if(tasks[i][1] > en) return false ;
            en-=tasks[i][0] ;
        }
        return true ;
    }
}