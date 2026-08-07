class Solution {
    public long minimumCost(int m, int n, int[]hc, int[] vc) {
         Arrays.sort(hc) ;
        Arrays.sort(vc) ;

        int i = hc.length - 1;
        int j = vc.length - 1;
        long cost = 0;
        int hp = 1;
        int vp = 1;
        while(i >= 0 && j >= 0) {
            if(hc[i] > vc[j]) {
                cost+=(hc[i]*vp) ;
                i--;
                hp++;
            }
            else {
                cost+=(vc[j]*hp) ;
                j--;
                vp++ ;
            }
        }

        while(i >= 0) {
             cost+=(hc[i]*vp) ;
                i--;
                hp++;
        }
         while(j >= 0) {
             cost+=(vc[j]*hp) ;
                j--;
                vp++;
        }
        return cost ;
    }
}