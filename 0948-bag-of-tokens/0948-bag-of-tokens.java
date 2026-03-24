class Solution {
    public int bagOfTokensScore(int[] t, int power) {

        int i = 0;
        int j = t.length-1;
        int s = 0;
        Arrays.sort(t);
        if(t.length == 0 || t[0] > power ) return 0;

        while(i < j){
          
            if(t[i] <= power){
                s++;
                power-=t[i];
                i++;

            }
            else {
               
                power+=t[j];
                 s--;
                j--;
            }

        }
        if(t[i]<=power) s++;
        return s;
        
    }
}