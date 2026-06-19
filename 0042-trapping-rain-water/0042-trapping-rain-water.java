class Solution {
    public int trap(int[] h) {
        int temp;
        int sum=0;
        int[] left=new int[h.length];
        int[] right= new int[h.length];
        left[0]=0;
        right[h.length-1]=0;
        for(int i=1;i<left.length; i++){
            left[i]=Math.max(left[i-1],h[i-1]);
        }
        for(int i=right.length-2; i>=0;i--){
            right[i]=Math.max(right[i+1],h[i+1]);
        }
        for(int i=0; i<h.length;i++){
            temp=Math.min(left[i],right[i]);
            if(temp<h[i]) sum+=0;
            else sum+=(temp-h[i]);
        }
        return sum;
    }
}