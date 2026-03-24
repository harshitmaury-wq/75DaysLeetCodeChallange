class Solution {
    public int maxArea(int[] h) {
        int i = 0;
        int j = h.length-1;
        int max = 0;
        int water = 0;
        while(i<=j){
            water = Math.min(h[i],h[j])*(j-i);
            max = Math.max(max, water);
            if(h[j]<=h[i]) j--;
            else i++;

        }
        return max;
    }
}