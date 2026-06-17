class Solution {
    public int minimumLines(int[][] sp)  {
        if(sp.length == 1) return 0;
        Arrays.sort(sp, (a, b) -> a[0] - b[0] ) ;

        int prev = Integer.MAX_VALUE;
        int cnt = 1;

        for(int i = 2; i<sp.length; i++) {
            if((sp[i][1] - sp[i-1][1]) *  (sp[i-1][0] - sp[i-2][0]) != (sp[i-1][1] - sp[i-2][1]) *
            (sp[i][0] - sp[i-1][0]) )           
            
                cnt++;

                
            }
        
        return cnt ;
    }
}