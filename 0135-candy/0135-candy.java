class Solution {
    public int candy(int[] rate) {
        int[] l2r = new int[rate.length];
        int[] r2l = new int[rate.length];

        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);
        for(int i=1 ; i<rate.length; i++){
            if(rate[i]>rate[i-1]) l2r[i] = l2r[i-1] + 1;
        }
        int sum = 0;
        for(int i = rate.length-2; i>=0; i--){
            if(rate[i] > rate[i+1]) r2l[i] = r2l[i+1] +1;
            
        }

        for(int i=0; i<rate.length; i++) sum+=Math.max(l2r[i], r2l[i]);
        
        return sum;
    }
}